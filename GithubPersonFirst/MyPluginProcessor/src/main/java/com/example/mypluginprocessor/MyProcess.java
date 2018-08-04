package com.example.mypluginprocessor;

import com.example.mypluginannotations.MyAnnotations;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

//@AutoService(Process.class)
public class MyProcess extends AbstractProcessor{


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("-----------------------------");
        for (Element element : roundEnvironment.getElementsAnnotatedWith(MyAnnotations.class)) {
            System.out.println("------------------------------222");
            // 判断元素的类型为Class
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement typeElement = (TypeElement) element;
                System.out.println(typeElement.getSimpleName());
                System.out.println(typeElement.getAnnotation(MyAnnotations.class).value());
            }
            System.out.println("------------------------------3333");
        }

        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class,"args")
                .addStatement("$T.out.println($S)",System.class,"hello JavaPoet")
                .build();
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC,Modifier.FINAL)
                .addMethod(main)
                .build();
        JavaFile javaFile = JavaFile.builder("com.example.helloworld",helloWorld)
                .build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotions = new LinkedHashSet<>();
        annotions.add(MyAnnotations.class.getCanonicalName());
        return annotions;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
