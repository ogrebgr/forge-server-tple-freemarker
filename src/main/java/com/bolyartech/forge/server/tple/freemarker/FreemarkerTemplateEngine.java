package com.bolyartech.forge.server.tple.freemarker;

import com.bolyartech.forge.server.misc.TemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


public class FreemarkerTemplateEngine implements TemplateEngine {
    private final Configuration mConfiguration;
    private final Map<String, Object> mAttributes = new HashMap<>();

    public FreemarkerTemplateEngine(Configuration configuration) {
        mConfiguration = configuration;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        try {
            StringWriter stringWriter = new StringWriter();
            Template template = mConfiguration.getTemplate(templateName);
            template.process(mAttributes, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
