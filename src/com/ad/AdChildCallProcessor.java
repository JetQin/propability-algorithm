package com.ad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdChildCallProcessor extends AdCallProcessor {
 
	private Collection<PlacementAdMapping> initializeData()
	{
		   Collection<PlacementAdMapping> initialData = new ArrayList<PlacementAdMapping>();
		   initialData.add(new PlacementAdMapping(1, 100, 10));
		   initialData.add(new PlacementAdMapping(2, 100, 10));
		   initialData.add(new PlacementAdMapping(2, 101, 20));
		   initialData.add(new PlacementAdMapping(2, 102, 20));
		   initialData.add(new PlacementAdMapping(3, 100, 15));
		   initialData.add(new PlacementAdMapping(3, 103, 5));
		   return initialData;
	}
	
	@Override
	public Collection<PlacementAdMapping> getAdsForPlacement( int placementId ){
		   
		 Collection<PlacementAdMapping> ads = initializeData();
		 List<PlacementAdMapping> adList = new ArrayList<PlacementAdMapping>();
		 for(PlacementAdMapping ad : ads)
		 {
			 if(ad.getPlacementId() == placementId)
			 {
				 adList.add(ad);
			 }
		 }
		 return adList;
	}
}
