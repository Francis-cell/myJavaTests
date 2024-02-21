package com.zmr.LearningFiles.MultiThreadTests.LockDemo;

import com.zmr.LearningFiles.MultiThreadTests.entity.Account;

/**
 * 通过使用加时赛锁-锁顺序避免死锁
 */
public class OrderLockDemo1 {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAccount,
                              final Account toAccount,
                              final double amount) {
        class Helper {
            public void transfer() {
                if (fromAccount.getBalance().compareTo(amount) < 0) {
                    throw new RuntimeException("账户余额不足!");
                } else {
                    // 当前账户 - 值
                    fromAccount.debit(amount);
                    // 被转账账户 + 值
                    toAccount.credit(amount);
                }
            }
        }

        // 使用 System.identityHashCode() 方法获取到当前 Object 的 hashCode 的值
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);

        if (fromHash < toHash) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().transfer();
                }
            }
        } else {
            // 使用加时赛锁
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}
