package concepts

import org.testng.Assert.*
import org.testng.annotations.Test
import java.io.ByteArrayInputStream
import java.math.BigDecimal
import java.nio.charset.Charset
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.*

/**
 * Resources:
 * https://www.baeldung.com/kotlin-reflection
 */
class Reflection {
    @Test
    fun workingWithClassRefsTest() {
        // Use ::class to get KClass instance ::class.java to get java.lang.class instance
        val list = List::class

        val name = "Gaurav"
        val stringClass = name::class

        // We can find out what type of class we are working with.
        assertEquals(stringClass.qualifiedName, "kotlin.String")

        assertFalse(stringClass.isData)
        assertFalse(stringClass.isCompanion)
        assertFalse(stringClass.isAbstract)
        assertFalse(stringClass.isSealed)
        assertTrue(stringClass.isFinal)
    }

    @Test
    fun traverseInClassHierarchyTest() {
        val stringClass = "Hello"::class
        println(stringClass.companionObjectInstance)
        println(stringClass.objectInstance)

        // We can create instance from a class reference using createInstance()
        val name = stringClass.createInstance()
        assertTrue(name is String)
    }

    @Test
    fun getConstructorsFunctionsAndMembersTest() {
        val bigDecimalClass = BigDecimal::class

        println(bigDecimalClass.constructors)
        println(bigDecimalClass.functions)
        println(bigDecimalClass.memberProperties)
        println(bigDecimalClass.memberExtensionProperties)
    }

    @Test
    fun callableReferencesTest() {
        val str = "Hello"
        val lengthMethod = str::length
        assertEquals(5, lengthMethod())

        val byteInputStream = String::byteInputStream

        assertEquals("byteInputStream", byteInputStream.name)
        assertFalse(byteInputStream.isSuspend)
        assertFalse(byteInputStream.isExternal)
        assertTrue(byteInputStream.isInline)
        assertTrue(byteInputStream.isOperator)
    }

    @Test
    fun getInfoAboutMethodInputAndOutputsTest() {
        val method = "Hello"::byteInputStream

        assertEquals(ByteArrayInputStream::class.starProjectedType, method.returnType)

        assertEquals(1, method.parameters.size)
        assertFalse(method.returnType.isMarkedNullable)

        assertTrue(method.parameters[0].isOptional)
        assertFalse(method.parameters[0].isVararg)
        assertEquals(Charset::class.starProjectedType, method.parameters[0].type)
    }

    lateinit var mutableProperty: String

    @Test
    fun kotlinPropertyReferencesTest() {
        val mProperty = this::mutableProperty

        assertEquals("mutableProperty", mProperty.name)
        assertTrue(mProperty.isLateinit)
        assertFalse(mProperty.isConst)
        assertTrue(mProperty is KMutableProperty<*>)
    }

}

