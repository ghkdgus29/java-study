import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @DisplayName("스택에 값을 push하여 저장하고, pop하여 꺼낸다.")
    @Test
    void pushAndPop() {
        // given
        Stack stack = new Stack(5);

        // when
        stack.push(1);
        int pop = stack.pop();

        // then
        assertThat(pop).isEqualTo(1);
    }

    @DisplayName("스택에서 pop을 하면 가장 마지막으로 push 한 값이 나온다.")
    @Test
    void multiplePushAndPop() {
        // given
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);

        // when
        int pop = stack.pop();

        // then
        assertThat(pop).isEqualTo(2);
    }

    @DisplayName("만약 생성할때 지정한 스택 크기보다 더 많이 push 하면 스택 오버플로우 에러를 던진다.")
    @Test
    void stackOverflow() {
        // given
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // when // then
        assertThatThrownBy(() -> stack.push(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("스택 오버플로우");
    }

    @DisplayName("만약 빈 스택에서 pop을 하면 스택 언더플로우 에러를 던진다.")
    @Test
    void stackUnderflow() {
        // given
        Stack stack = new Stack(3);

        // when // then
        assertThatThrownBy(() -> stack.pop())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("스택 언더플로우");
    }
}