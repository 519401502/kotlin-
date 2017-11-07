package annotation

import java.lang.annotation.RetentionPolicy

/**
 * Created by 18624915319 on 2017/8/17.
 */
@Target(AnnotationTarget.ANNOTATION_CLASS,
        AnnotationTarget.FIELD,
        AnnotationTarget.FILE,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION)
annotation class  IAnnotation