package com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils;

import com.zmr.LearningFiles.BooksReading.MultiThreadTests.syncUtils.entity.Board;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CellularAutomata {
    private final Board mainBoard;

    // 定义栅栏-barrier
    private final CyclicBarrier barrier;

    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        // 获取到当前 Java 虚拟机中正在运行的进程数量
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count,
                new Runnable() {
                    @Override
                    public void run() {
                        mainBoard.commitNewValues();
                    }
                });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            // workers[i] = new Worker()
        }
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computeValue(x, y));
                    }
                }

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }
    }

    private int computeValue(int x, int y) {
        return 100;
    }

    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        mainBoard.waitForConvergence();
    }
}
