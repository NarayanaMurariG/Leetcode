package design;


import java.util.*;
//https://leetcode.com/problems/design-twitter/
//All test cases passed
public class Twitter {

    public static void main(String[] args){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }

    private int counter;
    private Map<Integer,List<Integer>> userFollowers = new HashMap<>();
    private Map<Integer,Map<Integer,Integer>> userTweets = new HashMap<>();
    private List<Integer> tweets = new ArrayList<Integer>();

    public Twitter() {
        counter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Map<Integer,Integer> tweets;
        if(userTweets.containsKey(userId)){
            tweets = userTweets.get(userId);
        }else{
            tweets = new HashMap<Integer,Integer>();
        }
        counter++;
        tweets.put(counter,tweetId);
        userTweets.put(userId,tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> users = new ArrayList<Integer>();
        if(userFollowers.get(userId) != null){
            users.addAll(userFollowers.get(userId));
        }
        users.add(userId);


//        List<Integer> tweets = new ArrayList<Integer>();
        Map<Integer,Integer> tweets = new HashMap<Integer,Integer>();
        for(Integer user : users){
            if(userTweets.get(user) != null){
                tweets.putAll(userTweets.get(user));
            }
        }

        List<Integer> keys = new ArrayList<>(tweets.keySet());

        Collections.sort(keys,Collections.reverseOrder());
        List<Integer> finalTweets = new ArrayList<Integer>();
        if(keys.size() > 10){
            for(int i=0;i<10;i++){
                finalTweets.add(tweets.get(keys.get(i)));
            }
        }else{
            for(int i=0;i<keys.size();i++){
                finalTweets.add(tweets.get(keys.get(i)));
            }
        }
        return finalTweets;

    }

    public void follow(int followerId, int followeeId) {
        List<Integer> followerList;
        if(userFollowers.containsKey(followerId)){
            followerList = userFollowers.get(followerId);
        }else{
            followerList = new ArrayList<Integer>();
        }

        followerList.add(followeeId);
        userFollowers.put(followerId,followerList);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followerList = userFollowers.get(followerId);
        if(followerList == null){
            return;
        }
        int index = -1;
        for(Integer follower : followerList){
            index++;
            if(follower == followeeId){
                break;
            }
        }

        followerList.remove(index);
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */