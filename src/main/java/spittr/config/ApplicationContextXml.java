package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"spittr"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = ApplicationContextXml.WebPackge.class)
        })
public class ApplicationContextXml {
    public static class WebPackge extends RegexPatternTypeFilter {
        public WebPackge() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
}
