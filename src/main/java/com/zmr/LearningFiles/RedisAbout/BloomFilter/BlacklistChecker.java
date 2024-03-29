package com.zmr.LearningFiles.RedisAbout.BloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class BlacklistChecker {
    private static final int EXPECTED_INSERTIONS = 1000; // 预期插入数量
    private static final double FPP = 0.01; // 误判率

    private BloomFilter<CharSequence> bloomFilter;

    public BlacklistChecker() {
        // 创建 Bloom Filter 实例
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), EXPECTED_INSERTIONS, FPP);

        // 初始化黑名单数据
        initBlacklist();
    }

    // 初始化黑名单
    private void initBlacklist() {
        // 在这里假设我们有一个名字黑名单列表
        String[] blacklist = {"Alice", "Bob", "Charlie", "David"};

        // 将名字加入 Bloom Filter
        for (String name : blacklist) {
            bloomFilter.put(name);
        }
    }

    // 查询名字是否在黑名单中
    public boolean isBlacklisted(String name) {
        // 先通过 Bloom Filter 判断是否可能存在于黑名单中
        if (bloomFilter.mightContain(name)) {
            // 如果 Bloom Filter 返回存在，再进行准确的查询确认是否命中
            // 在这里可以使用其他更精确的方式，比如查询数据库
            return true;
        }
        return false;
    }

    // 更新黑名单
    public void updateBlacklist(String[] newBlacklist) {
        // 将新的黑名单信息加入 Bloom Filter
        for (String name : newBlacklist) {
            bloomFilter.put(name);
        }
    }

    public static void main(String[] args) {
        BlacklistChecker checker = new BlacklistChecker();
        System.out.println(checker.isBlacklisted("Alice")); // true
        System.out.println(checker.isBlacklisted("Eve")); // false

        // 模拟更新黑名单
        String[] newBlacklist = {"Eve", "Frank"};
        checker.updateBlacklist(newBlacklist);
        System.out.println(checker.isBlacklisted("Eve")); // true
        System.out.println(checker.isBlacklisted("Frank")); // true
    }
}

