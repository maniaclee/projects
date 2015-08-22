/*
package psyco.concurrent;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

*/
/**
 * Created by lipeng on 15/8/18.
 *//*

public class Thread_Executor_ForkJoin_Actor {

    public static String thread(String question, List<String> engines) {
        AtomicReference<String> result = new AtomicReference<>();
        for (String base : engines) {
            new Thread(() -> {
                result.compareAndSet(null, WS.url(getUrl(base, question)).get());
            }).start();
        }
        while (result.get() == null) ; // wait for some result to appear
        return result.get();
    }

    public static String executors(String question, List<String> engines) {
        ExecutorCompletionService<String> service = new ExecutorCompletionService(Executors.newFixedThreadPool(4));
        engines.forEach(e -> service.submit(() -> WS.url(getUrl(e, question)).get()));
        try {
            return service.take().get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    public static String lambdaForkJoin(String question, List<String> engines) {
        // get element as soon as it is available
        Optional<String> result = engines.stream()
                .parallel()
                .map(base -> WS.url(getUrl(base, question))
                        .get()).findAny();
        return result.get();
    }

    public static String actors(String question, List<String> engines) {
        ActorSystem system = ActorSystem.create("Search");
        AtomicReference<String> result = new AtomicReference<>();

        final ActorRef q = system.actorOf(
//                Props.create((UntypedActorFactory) () -> new Querier(question, engines, result)), "master");
                Props.create(Querier.class, question, engines, result), "master");
        q.tell(new Object(), ActorRef.noSender());

        while (result.get() == null) ;
        return result.get();
    }

    static class Message {
        String url;

        Message(String url) {
            this.url = url;
        }
    }

    static class Result {
        String html;

        Result(String html) {
            this.html = html;
        }
    }

    static class UrlFetcher extends UntypedActor {

        @Override
        public void onReceive(Object message) throws Exception {
            if (message instanceof Message) {
                Message work = (Message) message;
                String result = WS.url(work.url).get();
                getSender().tell(new Result(result), getSelf());
            } else {
                unhandled(message);
            }
        }
    }

    static class Querier extends UntypedActor {
        private String question;
        private List<String> engines;
        private AtomicReference<String> result;

        public Querier(String question, List<String> engines, AtomicReference<String> result) {

            this.question = question;
            this.engines = engines;
            this.result = result;
        }

        @Override
        public void onReceive(Object message) throws Exception {
            if (message instanceof Result) {
                result.compareAndSet(null, ((Result) message).html);
                getContext().stop(self());
            } else {
                for (String base : engines) {
                    String url = base + question;
                    ActorRef fetcher = this.getContext().actorOf(Props.create(UrlFetcher.class), "fetcher-" + base.hashCode());
                    Message m = new Message(url);
                    fetcher.tell(m, self());
                }
            }
        }
    }


    private static String getUrl(String base, String sub) {
        return base + sub;
    }


}
*/
