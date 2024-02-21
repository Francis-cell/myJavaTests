package com.zmr.LearningFiles.MultiThreadTests.LockDemo;

import com.zmr.LearningFiles.MultiThreadTests.entity.Account;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * <p>定时锁-避免死锁的发生</p>
 */
public class TryLockDemo {
    public boolean transferMoney(Account fromAccount,
                                 Account toAccount,
                                 double amount,
                                 long timeout,
                                 TimeUnit unit) throws InterruptedException{
        long fixedDelay = getFixedDelayComponentNanos(timeout, unit);
        long randMod = getRandomDelayModulusNanos(timeout, unit);
        long stopTime = System.nanoTime() + unit.toNanos(timeout);

        while (true) {
            if (fromAccount.lock.tryLock()) {
                try {
                    if (toAccount.lock.tryLock()) {
                        try {
                            if (fromAccount.getBalance().compareTo(amount) < 0) {
                                throw new RuntimeException("账户余额不足！");
                            } else {
                                fromAccount.debit(amount);
                                toAccount.credit(amount);
                                return true;
                            }
                        } finally {
                            toAccount.lock.unlock();
                        }
                    }
                } finally {
                    fromAccount.lock.unlock();
                }
            }

            if (System.nanoTime() < stopTime) {
                return false;
            }
            // 随机一个数据
            Random rnd = null;
            NANOSECONDS.sleep(fixedDelay + rnd.nextLong() % randMod);
        }
    }

    private long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
        return 1L;
    }

    private long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
        return 1L;
    }
}
