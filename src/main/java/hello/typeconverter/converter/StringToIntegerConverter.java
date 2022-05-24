package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    //파라미터: String, return 값: Integer
    public Integer convert(String source) {
        log.info("convert source={}", source);
        // Integer integer = Integer.valueOf(source);
        // return integer;  //Ctrl + Alt + N (인라인)
        return Integer.valueOf(source);
    }
}
