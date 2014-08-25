Interview:  Java coding exercise

Directions:
. Code in Java
. You are expected to complete this exercise by yourself.  Do not discuss with others ( applies to both online and offline communication )
. Feel free to use the Internet as a reference, e.g. Java documentation

-------------------------------
PART 1 - Ad Selection
-------------------------------

You are tasked with implementing an ad selection algorithm.

In this hypothetical ad server, an ad request looks like: http://adserver.com/showad?p=[placement_id]

AdCallProcessor implements the high level logic of processing each request:
 - look up all of the eligible ads, mapped to the placement_id ( getAdsForPlacement() )
 - choose an ad based on relative weight ( chooseAd() )

The placement to ad mapping logically looks like:

placement_id | ad_id | weight
 1           |  100  | 10
 2           |  100  | 10
 2           |  101  | 20
 2           |  102  | 20
 3           |  100  | 15
 3           |  103  | 5
 
Each row is represented by the provided PlacementAdMapping class.
The weight is an arbitrary integer ( between 1 and MAX_INTEGER ).   The weight determines the probability that an ad is chosen,
relative to the other ads mapped to the same placement_id.

Example ad selection behavior:
If the ad call is for p=1, then ad 100 is always shown.
If the ad call is for p=2, then ad 100,101, or 102 is chosen, with frequency ratio 10:20:20 ( i.e. on average, 100 is chosen 20% of the time, 101 is chosen 40% of the time, 102 is chosen 40% of the time )
If the ad call is for p=3, then ad 100 or 103 is chosen, with frequency ratio 15:5 ( i.e. on average, 100 is chosen 75% of the time, 103 chosen 25% of the time )


Skeleton code has been provided in AdCallProcessor.

(A) Implement AdCallProcessor.chooseAd() method, which chooses a creative from a set, based on the relative weights.

(B) Write test code to validate that chooseAd() is working properly.

