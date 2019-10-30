package com.example.swaggerdocument.util;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import java.net.URL;
import java.nio.file.Paths;

public class Swagger2Markup {

    /**
     * swagger的json数据
     */
    private static final String SWAGGER_API = "http://localhost:8080/officialWebsite/v2/api-docs.json";

    /**
     * 生成ascii文档格式
     *
     * @throws Exception
     */
    public static void generateAsciiDocs() throws Exception {
        // 输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH).withPathsGroupedBy(GroupBy.TAGS).withGeneratedExamples()
                .withoutInlineSchema().build();

        Swagger2MarkupConverter.from(new URL(SWAGGER_API)).withConfig(config).build()
                .toFolder(Paths.get("./docs/asciidoc/generated"));
    }

    /**
     * 生成AsciiDocs格式文档,并汇总成一个文件
     *
     * @throws Exception
     */
    public static void generateAsciiDocsToFile() throws Exception {
        // 输出Ascii到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH).withPathsGroupedBy(GroupBy.TAGS).withGeneratedExamples()
                .withoutInlineSchema().build();

        Swagger2MarkupConverter.from(new URL(SWAGGER_API)).withConfig(config).build()
                .toFile(Paths.get("./docs/asciidoc/generated/index"));
    }


    public static void main(String[] args) {
        try {
            generateAsciiDocsToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
