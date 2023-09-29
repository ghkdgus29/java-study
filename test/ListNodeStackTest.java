import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {

    @DisplayName("스택에 값을 push하여 저장하고, pop하여 꺼낸다.")
    @Test
    void pushAndPop() {
        // given
        ListNodeStack listNodeStack = new ListNodeStack();

        // when
        listNodeStack.push(1);
        int pop = listNodeStack.pop();

        // then
        assertThat(pop).isEqualTo(1);
    }

    @DisplayName("스택에서 pop을 하면 가장 마지막으로 push 한 값이 나온다.")
    @Test
    void multiplePushAndPop() {
        // given
        ListNodeStack listNodeStack = new ListNodeStack();
        listNodeStack.push(1);
        listNodeStack.push(2);

        // when
        int pop = listNodeStack.pop();

        // then
        assertThat(pop).isEqualTo(2);
    }

    @DisplayName("만약 빈 스택에서 pop을 하면 스택 언더플로우 에러를 던진다.")
    @Test
    void stackUnderflow() {
        // given
        ListNodeStack listNodeStack = new ListNodeStack();

        // when // then
        assertThatThrownBy(() -> listNodeStack.pop())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("스택 언더플로우");
    }

    @DisplayName("여러번 pop을 할 수 있다.")
    @Test
    void multiPop() {
        // given
        ListNodeStack listNodeStack = new ListNodeStack();
        listNodeStack.push(3);
        listNodeStack.push(2);
        listNodeStack.push(1);

        // when
        int pop1 = listNodeStack.pop();
        int pop2 = listNodeStack.pop();
        int pop3 = listNodeStack.pop();

        // then
        assertThat(pop1).isEqualTo(1);
        assertThat(pop2).isEqualTo(2);
        assertThat(pop3).isEqualTo(3);
    }

}