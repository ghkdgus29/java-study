package week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week4.ListNodeQueue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ListNodeQueueTest {

    @DisplayName("큐에 값을 offer하여 저장하고, poll하여 꺼낸다.")
    @Test
    void offerAndPoll() {
        // given
        ListNodeQueue listNodeQueue = new ListNodeQueue();

        // when
        listNodeQueue.offer(1);
        int poll = listNodeQueue.poll();

        // then
        assertThat(poll).isEqualTo(1);
    }

    @DisplayName("큐에서 poll을 하면 가장 처음 offer 한 값이 나온다.")
    @Test
    void multipleOfferAndPoll() {
        // given
        ListNodeQueue listNodeQueue = new ListNodeQueue();
        listNodeQueue.offer(1);
        listNodeQueue.offer(2);

        // when
        int poll = listNodeQueue.poll();

        // then
        assertThat(poll).isEqualTo(1);
    }

    @DisplayName("큐에서 여러번 poll을 할 수 있다.")
    @Test
    void multiplePoll() {
        // given
        ListNodeQueue listNodeQueue = new ListNodeQueue();
        listNodeQueue.offer(1);
        listNodeQueue.offer(2);

        // when
        int poll1 = listNodeQueue.poll();
        int poll2 = listNodeQueue.poll();

        // then
        assertThat(poll1).isEqualTo(1);
        assertThat(poll2).isEqualTo(2);
    }

    @DisplayName("만약 빈 큐에서 poll을 하면 큐 언더플로우 에러를 던진다.")
    @Test
    void stackUnderflow() {
        // given
        ListNodeQueue listNodeQueue = new ListNodeQueue();

        // when // then
        assertThatThrownBy(() -> listNodeQueue.poll())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("큐 언더플로우");
    }

}