package com.unionbankph.hrxmobility.presentation.view

abstract class SampleAbstract {

    abstract fun process()

    fun aMethodYouDontWantToCallOnEveryClassThatImplementsThisClass(){
        // the implementation
    }
}

class SampleA : SampleAbstract() {

    private val something: String? = null

    override fun process() {
        // implementation for sample A
    }

}

class SampleB : SampleAbstract() {

    public val something: String? = null

    override fun process() {
        // implementation for sample B
    }

}

class ThatUsesTheInterface(private val sampleInterface: SampleAbstract){

    fun randomMethod(){
        sampleInterface.process() // The implementation depends on the provided class (SampleA or SampleB)
    }

}

class AnotherClass(private val mThatUsesTheInterface: ThatUsesTheInterface) {

    val sampleClass: ThatUsesTheInterface? = ThatUsesTheInterface(SampleA())
    // OR
    val sampleCass :ThatUsesTheInterface? = ThatUsesTheInterface(SampleB())

}