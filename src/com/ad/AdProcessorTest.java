package com.ad;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Before;
import org.junit.Test;

public class AdProcessorTest {

	AdChildCallProcessor processor;
	Map<PlacementAdMapping,Integer> dataMap = new HashMap<PlacementAdMapping,Integer>();
	
	@Before
	public void setup()
	{
		//统计700000次中个PlacementAdMapping出现的次数，统计规模越大，统计出来的概率越接近于weight值的概率
	    processor = new AdChildCallProcessor();
		Collection<PlacementAdMapping> ads = processor.getAdsForPlacement(2);
		for (int index = 0; index < 700000; index++) 
		{
			PlacementAdMapping ad = processor.chooseAd(ads);
			if(dataMap.containsKey(ad))
			{
				dataMap.put(ad, dataMap.get(ad)+1);
			}
			else
			{
				dataMap.put(ad, 1);
			}
		}
	}
	
	@Test
	public void testChooseAd() 
	{
		
		PlacementAdMapping compareTarget = null;
		Integer count = 0;
		boolean isFirst = true;
		
		Iterator it = dataMap.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<PlacementAdMapping,Integer> entry = (Entry<PlacementAdMapping,Integer>) it.next();
			if(isFirst)
			{
				//get the first element as the base compare object
			    compareTarget = entry.getKey();
			    count = entry.getValue();
			    System.out.println("***************************");
			    System.out.println(String.format("[%s] frequency [%d]",compareTarget.getCreativeId(), count));
			    isFirst = false;
			}
			else
			{
				//analystic 不同PlacementAdMapping在dataMap中出现的次数比值 与 PlacementAdMapping之间的weight的比值近似相等
				System.out.println("***************************");
				System.out.println(String.format("[%s] frequency [%d]",entry.getKey().getCreativeId(), entry.getValue()));
			    double adCompare = (double)entry.getKey().getWeight() / compareTarget.getWeight();
			   	double countCompare = (double)entry.getValue() / count;
			   	
			   	System.out.println(String.format("ad compare:[%f] count compate:[%f]",adCompare, countCompare));				
			   	assertEquals(Math.round(adCompare-countCompare),0 );
			}
		}
	}

}
