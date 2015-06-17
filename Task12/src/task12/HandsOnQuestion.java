/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task12;

/**
 *
 * @author cb-admin1
 */
public class HandsOnQuestion extends Question{
    private final String questionDesc;
    private final String referenceDocument;

    public HandsOnQuestion(int marks,String questionDesc,String referenceDocument) {
        super(marks);
        this.questionDesc = questionDesc;
        this.referenceDocument = referenceDocument;
    }
    
}
