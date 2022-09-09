/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfcti.cbsutils;

/**
 *
 * @author rodolfo.matamoros
 */
class IncorrectFolderNameException extends RuntimeException {

    public IncorrectFolderNameException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
