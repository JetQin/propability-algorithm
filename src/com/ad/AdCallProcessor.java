package com.ad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class AdCallProcessor {
	
	//hypothetical high-level ad call logic...
	public void handleAdCall( int placementId ){
		
		//which ads are mapped to this placement
		Collection<PlacementAdMapping> eligibleAds = getAdsForPlacement( placementId );
		
		//choose one of the ads based on relative weight
		PlacementAdMapping chosenAd = chooseAd( eligibleAds );

		//... render the ad
		System.out.println( chosenAd );
	}
	
	/**
	 * Choose one of the ads ( based on relative weight )
	 * 算法实现
	 * 按［0～a+b+c］区间进行区分
	 * 权值为a的出现在0～a这个区间，
	 * 权值为b的出现在a～a+b这个区间
	 * 权值为c的出现在a＋b～a+b+c这个区间
	 * 以Random.nextInt(a+b+c)取得随机值，当随机值出现在［0～a］则为第一个概率，在［a～a+b］为第二个概率，在［a+b～a+b+c］为第三个概率
	 * @param ads list of ads to choose from
	 * @return the chosen ad
	 */
	public PlacementAdMapping chooseAd( Collection<PlacementAdMapping> ads ){
		//TODO: implement me
		if(null == ads){return null;}

		int weight = 0;
		for(PlacementAdMapping ad : ads)
		{
			weight += ad.getWeight();
		}
		
		int chance = new Random().nextInt(weight) + 1;
		for (PlacementAdMapping ad : ads) 
		{
			chance -= ad.getWeight();
			if(chance <= 0)
			{
				return ad;
			}
		}
		
		return null;
	}
	

	/**
	 * returns the ads mapped to a given placement
	 * 
	 * @param placementId
	 * @return collection of PlacementAd objects mapped to placement
	 */
	protected Collection<PlacementAdMapping> getAdsForPlacement( int placementId ){
		//
		// In a "real" implementation, this info would probably be read from a DB...
		//
		// For this exercise, feel free to override this for the purpose of testing
		//
		return new ArrayList<PlacementAdMapping>();
	}
	
}
