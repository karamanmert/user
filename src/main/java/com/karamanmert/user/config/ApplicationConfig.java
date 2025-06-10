package com.karamanmert.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author karamanmert
 */
@Configuration
public class ApplicationConfig {

    @Value("${messages.default.language}")
    private String defaultLanguage;

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.forLanguageTag(defaultLanguage));
        List<Locale> supportedLocales = Arrays.asList(Locale.forLanguageTag("tr"), Locale.forLanguageTag("en"));
        acceptHeaderLocaleResolver.setSupportedLocales(supportedLocales);
        return acceptHeaderLocaleResolver;
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setFallbackToSystemLocale(false);
        return resourceBundleMessageSource;
    }
}
