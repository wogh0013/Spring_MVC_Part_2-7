package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    //IpPort 객체를 입력 -> "127.0.0.1:8080" 과 같은 문자를 반환
    @Override
    public String convert(IpPort source) {
        log.info("convert source={}", source);

        return source.getIp() + ":" + source.getPort();
    }
}
