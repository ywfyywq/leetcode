package com.xyz0751.learn.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 355. 设计推特
 *
 * 难度 中等
 *
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 *
 * 实现 Twitter 类：
 *
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用次函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近   10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 *   
 *
 * 示例：
 *
 * 输入
 * ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
 * [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 * 输出
 * [null, null, [5], null, null, [6, 5], null, [5]]
 *
 * 解释
 * Twitter twitter = new Twitter();
 * twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
 * twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
 * twitter.follow(1, 2);    // 用户 1 关注了用户 2
 * twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
 * twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
 * twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
 * twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
 *   
 *
 * 提示：
 *
 * 1 <= userId, followerId, followeeId <= 500
 * 0 <= tweetId <= 104
 * 所有推特的 ID 都互不相同
 * postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 104 次
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Twitter {

    /**
     * 推特及用户关联表
     */
    Map<Integer, Integer> tweetUser;
    /**
     * 推特列表
     */
    List<Integer> tweetList;
    /**
     * 关注列表
     */
    Map<Integer, List<Integer>> followList;

    public Twitter() {
        tweetUser = new HashMap<>(512);
        tweetList = new ArrayList<>(512);
        followList = new HashMap<>(512);
    }

    public void postTweet(int userId, int tweetId) {
        tweetUser.put(tweetId, userId);
        tweetList.add(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        int count = 10;
        List<Integer> feedList = new ArrayList<>();
        for (int i = tweetList.size()-1; i>=0 && count>0; i--) {
            int tweetUserId = tweetUser.get(tweetList.get(i));
            if (tweetUserId == userId) {
                feedList.add(tweetList.get(i));
                count--;
            } else {
                if (followList.getOrDefault(userId, new ArrayList<>()).contains(tweetUserId)) {
                    feedList.add(tweetList.get(i));
                    count--;
                }
            }
        }

        return feedList;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> list = followList.getOrDefault(followerId, new ArrayList<>());
        if (!list.contains(followeeId)) {
            list.add(followeeId);
            followList.put(followerId, list);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followList.containsKey(followerId)) {
            List<Integer> list = followList.get(followerId);
            if (list.contains(followeeId)) {
                list.remove(new Integer(followeeId));
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        System.out.println(twitter.getNewsFeed(1));  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.follow(1, 2);    // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.postTweet(3, 7);    // 用户 1 关注了用户 2
        System.out.println(twitter.getNewsFeed(1));  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
        System.out.println(twitter.getNewsFeed(1)); // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }
}
