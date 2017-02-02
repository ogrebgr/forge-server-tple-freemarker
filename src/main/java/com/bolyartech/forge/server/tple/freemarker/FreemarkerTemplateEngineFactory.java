package com.bolyartech.forge.server.tple.freemarker;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import freemarker.template.Configuration;
import freemarker.template.Version;

import java.io.File;
import java.net.URL;


public class FreemarkerTemplateEngineFactory implements TemplateEngineFactory {
    private final String mTemplatePathPrefix;
    private final Configuration mConfiguration;

    public FreemarkerTemplateEngineFactory(String templatePathPrefix) {
        if (!templatePathPrefix.startsWith(File.separator)) {
            templatePathPrefix = File.separator + templatePathPrefix;
        }
        mTemplatePathPrefix = templatePathPrefix;

        mConfiguration = new Configuration(new Version(2, 3, 23));
        mConfiguration.setClassForTemplateLoading(this.getClass(), mTemplatePathPrefix);
    }


    public FreemarkerTemplateEngineFactory(String templatePathPrefix, Configuration configuration) {
        mTemplatePathPrefix = templatePathPrefix;
        mConfiguration = configuration;
    }


    @Override
    public TemplateEngine createNew() {
        return new FreemarkerTemplateEngine(mConfiguration);
    }
}
