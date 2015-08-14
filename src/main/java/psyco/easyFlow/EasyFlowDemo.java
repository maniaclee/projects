package psyco.easyFlow;

import au.com.ds.ef.*;
import com.google.common.collect.Lists;
import org.junit.Test;

import static au.com.ds.ef.FlowBuilder.from;
import static au.com.ds.ef.FlowBuilder.on;

/**
 * Created by lipeng on 15/7/24.
 */
public class EasyFlowDemo {

    public static class FlowContext<T> extends StatefulContext {
        private T result;

        public FlowContext(StateEnum state, T result) {
            this.setState(state);
            this.result = result;
        }

        public FlowContext(StateEnum state) {
            this(state, null);
        }

        public T getResult() {
            return result;
        }

        public FlowContext setResult(T result) {
            this.result = result;
            return this;
        }

    }

    static enum States implements StateEnum {
        WAITING_FOR_PIN, RETURNING_CARD, SHOWING_WELCOME
    }

    static enum Events implements EventEnum {
        cardPresent, pinProvided, cardExtracted, cancel
    }

    @Test
    public void test() {
        EasyFlow<StatefulContext> flow =
                from(States.SHOWING_WELCOME).transit(
                        on(Events.cardPresent).to(States.WAITING_FOR_PIN).transit(
                                on(Events.pinProvided).to(States.RETURNING_CARD).transit(
                                ),
                                on(Events.cancel).to(States.RETURNING_CARD).transit(
                                        on(Events.cardExtracted).to(States.SHOWING_WELCOME)
                                )
                        )
                );
        flow.executor(new SyncExecutor())
                .whenEnter(States.SHOWING_WELCOME, statefulContext -> {
                    System.out.println("welcome");
                    statefulContext.trigger(Events.cardPresent);
                    throw new RuntimeException("sdfsdfsdfsdf");
                })
                .whenEnter(States.WAITING_FOR_PIN, statefulContext1 ->
                        System.out.println("waiting"));
        StatefulContext ctx = new StatefulContext();
        flow.start(true, ctx);
        System.out.println(ctx.getState());
        System.out.println("fuck");
    }

    @Test
    public void sdfsdf() {
        System.out.println(Lists.newArrayList().stream().getClass().getName());
    }
}
