package calculator.domain;


import static calculator.global.constant.ErrorMessage.CUSTOM_SEPARATOR_INDEX_ERROR_MESSAGE;

import calculator.global.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LetterMannagerTest {
    @Test
    void 커스텀_구분자_입력_시_끝나는_문자열이_나오지_않을_경우_예외_처리() {
        //given
        String letters = "//hello";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);

        //then
        Assertions.assertThatThrownBy(letterMannager::splitCustomSeparator)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CUSTOM_SEPARATOR_INDEX_ERROR_MESSAGE);
    }

    @Test
    void 커스텀_구분자를_추출() {
        //given
        String separator = ";";
        String letters = "//" + separator + "\\n";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);
        letterMannager.splitCustomSeparator();

        //then
        Assertions.assertThat(letterMannager.getSeparators().contains(separator)).isEqualTo(true);
    }

    @Test
    void 커스텀_구분자가_없는_상황에서_입력받은_문자열에서_숫자를_추출() {
        //given
        String letters = "1,2:3";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);
        letterMannager.splitNumber();

        //then
        Assertions.assertThat(letterMannager.getNumbers().toInteger().contains(1)).isEqualTo(true);
        Assertions.assertThat(letterMannager.getNumbers().toInteger().contains(2)).isEqualTo(true);
        Assertions.assertThat(letterMannager.getNumbers().toInteger().contains(3)).isEqualTo(true);
    }

    @Test
    void 커스텀_구분자가_있는_상황에서_입력받은_문자열에서_숫자를_추출() {
        //given
        String letters = "//;\\n1;2";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);
        letterMannager.splitCustomSeparator();
        letterMannager.splitNumber();

        //then
        Assertions.assertThat(letterMannager.getNumbers().toInteger().contains(1)).isEqualTo(true);
        Assertions.assertThat(letterMannager.getNumbers().toInteger().contains(2)).isEqualTo(true);
    }

    @Test
    void 추출한_문자가_구분자에_등록되어_있지_않다면_예외_처리() {
        //given
        String letters = "1;2";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);

        //then
        Assertions.assertThatThrownBy(letterMannager::splitNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
    }


}