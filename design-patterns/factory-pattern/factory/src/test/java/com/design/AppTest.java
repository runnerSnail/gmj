package com.design;

import static org.junit.Assert.assertTrue;

import com.design.lib.N95MaskFactory;
import com.design.lib.SurgeryMaskFactory;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SurgeryMaskFactory surgeryMaskFactory = new SurgeryMaskFactory();
        System.out.println(surgeryMaskFactory.create());
        N95MaskFactory n95MaskFactory = new N95MaskFactory();
        System.out.println(n95MaskFactory.create());
        assertTrue( true );
    }
}
