package com.zmr.LearningFiles.OwnLearning.BasicJava.tryCatch;

/**
 * @ClassName TryWithResourse
 * @Description 
 **/
public class TryWithResourse {
    public static void main(String[] args) {
        try(Resource res = new Resource()) {
            res.doSome();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    static class Resource implements AutoCloseable {
        void doSome() {
            System.out.println("do something");
        }
        @Override
        public void close() throws Exception {
            System.out.println("resource is closed");
        }
    }
}
