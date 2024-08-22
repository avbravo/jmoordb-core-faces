/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.processor.analizer.util.view;

import com.jmoordb.core.annotation.view.VForm;
import static com.jmoordb.core.util.JmoordbCoreUtil.isFirstCharacter;
import static com.jmoordb.core.util.JmoordbCoreUtil.removeFirstCharacter;
import com.jmoordb.core.util.MessagesUtil;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.VariableElement;

/**
 *
 * @author avbravo
 */
public class VFormAnalizerUtil {
    // <editor-fold defaultstate="collapsed" desc="Boolean nameOfParametersEqualsToNameOfMethod((List<String> tokenList, List<? extends VariableElement> parameters String nameOfMethod) ">

    /**
     * Verifica que los nombres de parametros @ coindican con los parametros
     *
     * @param tokenList
     * @param parameters
     * @param nameOfMethod
     * @return
     */
    public static Boolean nameOfParametersEqualsToNameOfMethod(List<String> tokenList, List<? extends VariableElement> parameters, String nameOfMethod) {
        Boolean isValid = Boolean.FALSE;
        try {
// Evalua la columna @PARA --> Parametros           
//| size | iden       | LOG          | @PARA        | BOOL     | ()|
//| ---  | ------     | ---          |---           |---       |-- |
//|  3   | 0          |  1           | 2            |--        | 1 |
//|  7   | 0,4        |  1,5         | 2,6          | 3        | 2 |
//|  11  | 0,4,8      |  1,5,9       | 2,6,10       | 3,7      | 3 |
//|  15  | 0,4,8,12   |  1,5,9,13    | 2,6,10,14    | 3,7,11   | 4 |
//|  19  | 0,4,8,12,16|  1,5,9,13,17 | 2,6,10,14,18 | 3,7,11,15| 5 |
            Boolean position2 = Boolean.FALSE;
            Boolean position6 = Boolean.FALSE;
            Boolean position10 = Boolean.FALSE;
            Boolean position14 = Boolean.FALSE;
            Boolean position18 = Boolean.FALSE;

            switch (tokenList.size()) {
                case 3:
// verifica que el parametro este dentro del where()
                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if (removeFirstCharacter(tokenList.get(2)).equals(param.getSimpleName().toString())) {
                            isValid = Boolean.TRUE;
                            break;
                        }

                    }

                    break;
                case 7:

                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if (removeFirstCharacter(tokenList.get(2)).equals(param.getSimpleName().toString())) {
                            position2 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(6)).equals(param.getSimpleName().toString())) {
                            position6 = Boolean.TRUE;

                        }

                    }
                    if (position2 && position6) {
                        isValid = Boolean.TRUE;
                    }
                    break;
                case 11:

                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if (removeFirstCharacter(tokenList.get(2)).equals(param.getSimpleName().toString())) {
                            position2 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(6)).equals(param.getSimpleName().toString())) {
                            position6 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(10)).equals(param.getSimpleName().toString())) {
                            position10 = Boolean.TRUE;
                        }

                    }

                    if (position2 && position6 && position10) {
                        isValid = Boolean.TRUE;

                    }
                    break;
                case 15:
                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if (removeFirstCharacter(tokenList.get(2)).equals(param.getSimpleName().toString())) {
                            position2 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(6)).equals(param.getSimpleName().toString())) {
                            position6 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(10)).equals(param.getSimpleName().toString())) {
                            position10 = Boolean.TRUE;
                        }
                        if (removeFirstCharacter(tokenList.get(14)).equals(param.getSimpleName().toString())) {
                            position14 = Boolean.TRUE;
                        }

                    }
                    if (position2 && position6 && position10 && position14) {
                        isValid = Boolean.TRUE;

                    }
                    break;

                case 19:
                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if (removeFirstCharacter(tokenList.get(2)).equals(param.getSimpleName().toString())) {
                            position2 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(6)).equals(param.getSimpleName().toString())) {
                            position6 = Boolean.TRUE;

                        }
                        if (removeFirstCharacter(tokenList.get(10)).equals(param.getSimpleName().toString())) {
                            position10 = Boolean.TRUE;
                        }
                        if (removeFirstCharacter(tokenList.get(14)).equals(param.getSimpleName().toString())) {
                            position14 = Boolean.TRUE;
                        }
                        if (removeFirstCharacter(tokenList.get(18)).equals(param.getSimpleName().toString())) {
                            position18 = Boolean.TRUE;
                        }

                    }
                    if (position2 && position6 && position10 && position14 && position18) {
                        isValid = Boolean.TRUE;

                    }

                    break;
            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean nameOfIdentificatorEqualsToNameOfMethod<String> tokenList, List<? extends VariableElement> parameters, String nameOfMethod)">

    /**
     * Verifica que nos nombres de identificadores coincidan con los parameros
     * de los métodos
     *
     * @param tokenList
     * @param parameters
     * @param nameOfMethod
     * @return
     */
    public static Boolean nameOfIdentificatorEqualsToNameOfMethod(List<String> tokenList, List<? extends VariableElement> parameters, String nameOfMethod) {
        Boolean isValid = Boolean.FALSE;
        try {
// Evalua la column iden
//| size | iden       | LOG          | @PARA        | BOOL     | ()|
//| ---  | ------     | ---          |---           |---       |-- |
//|  3   | 0          |  1           | 2            |--        | 1 |
//|  7   | 0,4        |  1,5         | 2,6          | 3        | 2 |
//|  11  | 0,4,8      |  1,5,9       | 2,6,10       | 3,7      | 3 |
//|  15  | 0,4,8,12   |  1,5,9,13    | 2,6,10,14    | 3,7,11   | 4 |
//|  19  | 0,4,8,12,16|  1,5,9,13,17 | 2,6,10,14,18 | 3,7,11,15| 5 |
            Boolean position0 = Boolean.FALSE;
            Boolean position4 = Boolean.FALSE;
            Boolean position8 = Boolean.FALSE;
            Boolean position12 = Boolean.FALSE;
            Boolean position16 = Boolean.FALSE;

            switch (tokenList.size()) {
                case 3:
// verifica que el parametro este dentro del where()
                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if ((tokenList.get(0)).equals(param.getSimpleName().toString())) {
                            isValid = Boolean.TRUE;
                            break;
                        }

                    }

                    break;
                case 7:

                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if ((tokenList.get(0)).equals(param.getSimpleName().toString())) {
                            position0 = Boolean.TRUE;
                        }
                        if ((tokenList.get(4)).equals(param.getSimpleName().toString())) {
                            position4 = Boolean.TRUE;

                        }

                    }
                    if (position0 && position4) {
                        isValid = Boolean.TRUE;

                    }
                    break;
                case 11:

                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if ((tokenList.get(0)).equals(param.getSimpleName().toString())) {
                            position0 = Boolean.TRUE;

                        }
                        if ((tokenList.get(4)).equals(param.getSimpleName().toString())) {
                            position4 = Boolean.TRUE;

                        }
                        if ((tokenList.get(8)).equals(param.getSimpleName().toString())) {
                            position8 = Boolean.TRUE;
                        }

                    }
                    if (position0 && position4 && position8) {
                        isValid = Boolean.TRUE;
                    }
                    break;
                case 15:
                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if ((tokenList.get(0)).equals(param.getSimpleName().toString())) {
                            position0 = Boolean.TRUE;

                        }
                        if ((tokenList.get(4)).equals(param.getSimpleName().toString())) {
                            position4 = Boolean.TRUE;

                        }
                        if ((tokenList.get(8)).equals(param.getSimpleName().toString())) {
                            position8 = Boolean.TRUE;
                        }
                        if ((tokenList.get(12)).equals(param.getSimpleName().toString())) {
                            position12 = Boolean.TRUE;
                        }

                    }
                    if (position0 && position4 && position8 && position12) {
                        isValid = Boolean.TRUE;
                    }
                    break;
                case 19:
                    for (int i = 0; i < parameters.size(); i++) {
                        VariableElement param = parameters.get(i);
                        if ((tokenList.get(0)).equals(param.getSimpleName().toString())) {
                            position0 = Boolean.TRUE;

                        }
                        if ((tokenList.get(4)).equals(param.getSimpleName().toString())) {
                            position4 = Boolean.TRUE;

                        }
                        if ((tokenList.get(8)).equals(param.getSimpleName().toString())) {
                            position8 = Boolean.TRUE;
                        }
                        if ((tokenList.get(12)).equals(param.getSimpleName().toString())) {
                            position12 = Boolean.TRUE;
                        }
                        if ((tokenList.get(16)).equals(param.getSimpleName().toString())) {
                            position16 = Boolean.TRUE;
                        }

                    }
                    if (position0 && position4 && position8 && position12 && position16) {
                        isValid = Boolean.TRUE;
                    }
                    break;

            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean rulesValid(List<String> tokenList, String nameOfMethod ,Boolean havePaginationParameters, Boolean haveSortedParameters)">
    /**
     * Valida que se cumplan las reglas del vForm, en cuanto a que elementos deben estar incluidos y en qye posicion
     * verifica los nombres de atributos 
     * @param vForm
     * @param tokenList
     * @param nameOfMethod
     * @param havePaginationParameters
     * @param haveSortedParameters
     * @return 
     */
    public static Boolean rulesValid(VForm vForm, List<String> tokenList, String nameOfMethod, Boolean havePaginationParameters, Boolean haveSortedParameters) {
        Boolean isValid = Boolean.FALSE;
        try {
// Valida posicion por posicio los elementos
//| size | identif    | LOGICAL      | @PARAMETERS  | BOOLEAN  | ()|
//| ---  | ------     | ---          |---           |---       |-- |
//|  3   | 0          |  1           | 2            |--        | 1 |
//|  7   | 0,4        |  1,5         | 2,6          | 3        | 2 |
//|  11  | 0,4,8      |  1,5,9       | 2,6,10       | 3,7      | 3 |
//|  15  | 0,4,8,12   |  1,5,9,13    | 2,6,10,14    | 3,7,11   | 4 |
//|  19  | 0,4,8,12,16|  1,5,9,13,17 | 2,6,10,14,18 | 3,7,11,15| 5 |

/**
 * Analiza si el metodo tiene solo Pagination y Sorted
 * @VForm(where="pagination .skip. @pagination .order. sorted .by. @sorted")
 *  public List<Oceano> findAllPaginationSorted(Pagination pagination, Sorted sorted);
 * 
 */
if(!havePaginationParameters){
    Optional<String> limitFound = tokenList
            .stream()
            .filter(token -> token.equals(".limit."))
            .findAny();
    Optional<String> skipFound = tokenList
            .stream()
            .filter(token -> token.equals(".skip."))
            .findAny();
     
         if(limitFound.isPresent() || skipFound.isPresent()){
             return Boolean.FALSE;
         }
     
}

if(!haveSortedParameters){
    Optional<String> orderFound = tokenList
            .stream()
            .filter(token -> token.equals(".order."))
            .findAny();
    Optional<String> byFound = tokenList
            .stream()
            .filter(token -> token.equals(".by."))
            .findAny();
       
      
         if(orderFound.isPresent() || byFound.isPresent()){
             return Boolean.FALSE;
         }
     

}

           
                   



            switch (tokenList.size()) {
                case 3:
                    /**
                     * Verificar que no tenga paginación y ordenación
                     *
                     * @VForm(id .eq. @id) findAll(String id)
                     */
                    if (!havePaginationParameters && !haveSortedParameters) {
                        
                        if (nameOfJavaIdentifierValid(tokenList.get(0))
                                && isValidLogicalOperator(tokenList.get(1))
                                && isFirstCharacter(tokenList.get(2), "@")) {
                            isValid = Boolean.TRUE;
                        }

                    } else {
                        /**
                         * Si es una paginación
                         *
                         * @VForm(pagination .skip. @pagination)
                         * findAll(Pagination pagination)
                         */
                        if (havePaginationParameters) {

                            if (nameOfJavaIdentifierValid(tokenList.get(0))
                                    && compare(tokenList.get(1), ".skip.")
                                    && isFirstCharacter(tokenList.get(2), "@")) {
                                isValid = Boolean.TRUE;
                            }
                        } else {
                            /**
                             * Si es una ordenacióm
                             *
                             * @VForm(sorted .by. @sorted) findAll(Sorted
                             * sorted)
                             */

                            if (haveSortedParameters) {
                                if (nameOfJavaIdentifierValid(tokenList.get(0))
                                        && compare(tokenList.get(1), ".by.")
                                        && isFirstCharacter(tokenList.get(2), "@")) {
                                    isValid = Boolean.TRUE;

                                }
                            }
                        }
                    }

                    break;

                case 7:
                    if (nameOfJavaIdentifierValid(tokenList.get(0))
                            && nameOfJavaIdentifierValid(tokenList.get(4))
                            && isValidLogicalOperator(tokenList.get(1))
                            && isValidLogicalOperator(tokenList.get(5))
                            && isFirstCharacter(tokenList.get(2), "@")
                            && isFirstCharacter(tokenList.get(6), "@")
                            && isValidBooleanOperador(tokenList.get(3))) {
                        isValid = Boolean.TRUE;
                    }
                    break;
                case 11:
                    if (nameOfJavaIdentifierValid(tokenList.get(0))
                            && nameOfJavaIdentifierValid(tokenList.get(4))
                            && nameOfJavaIdentifierValid(tokenList.get(8))
                            && isValidLogicalOperator(tokenList.get(1))
                            && isValidLogicalOperator(tokenList.get(5))
                            && isValidLogicalOperator(tokenList.get(9))
                            && isFirstCharacter(tokenList.get(2), "@")
                            && isFirstCharacter(tokenList.get(6), "@")
                            && isFirstCharacter(tokenList.get(10), "@")
                            && isValidBooleanOperador(tokenList.get(3))
                            && isValidBooleanOperador(tokenList.get(7))) {
                        isValid = Boolean.TRUE;
                    }
                    break;
                case 15:
                    if (nameOfJavaIdentifierValid(tokenList.get(0))
                            && nameOfJavaIdentifierValid(tokenList.get(4))
                            && nameOfJavaIdentifierValid(tokenList.get(8))
                            && nameOfJavaIdentifierValid(tokenList.get(12))
                            && isValidLogicalOperator(tokenList.get(1))
                            && isValidLogicalOperator(tokenList.get(5))
                            && isValidLogicalOperator(tokenList.get(9))
                            && isValidLogicalOperator(tokenList.get(13))
                            && isFirstCharacter(tokenList.get(2), "@")
                            && isFirstCharacter(tokenList.get(6), "@")
                            && isFirstCharacter(tokenList.get(10), "@")
                            && isFirstCharacter(tokenList.get(14), "@")
                            && isValidBooleanOperador(tokenList.get(3))
                            && isValidBooleanOperador(tokenList.get(7))
                            && isValidBooleanOperador(tokenList.get(11))) {
                        isValid = Boolean.TRUE;
                    }
                    break;
                case 19:

                    if (nameOfJavaIdentifierValid(tokenList.get(0))
                            && nameOfJavaIdentifierValid(tokenList.get(4))
                            && nameOfJavaIdentifierValid(tokenList.get(8))
                            && nameOfJavaIdentifierValid(tokenList.get(12))
                            && nameOfJavaIdentifierValid(tokenList.get(16))
                            && isValidLogicalOperator(tokenList.get(1))
                            && isValidLogicalOperator(tokenList.get(5))
                            && isValidLogicalOperator(tokenList.get(9))
                            && isValidLogicalOperator(tokenList.get(13))
                            && isValidLogicalOperator(tokenList.get(17))
                            && isFirstCharacter(tokenList.get(2), "@")
                            && isFirstCharacter(tokenList.get(6), "@")
                            && isFirstCharacter(tokenList.get(10), "@")
                            && isFirstCharacter(tokenList.get(14), "@")
                            && isFirstCharacter(tokenList.get(18), "@")
                            && isValidBooleanOperador(tokenList.get(3))
                            && isValidBooleanOperador(tokenList.get(7))
                            && isValidBooleanOperador(tokenList.get(11))
                            && isValidBooleanOperador(tokenList.get(15))) {
                        isValid = Boolean.TRUE;
                    }
                    break;

            }

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Boolean isValidLogicalOperator(String vForm)">
    /**
     *
     * @param vForm
     * @return TRUE/FALSE si es un operador valido Los operadores validos estan
     * en las posiciones impares id .eq. @id .and. name .eq. @name Si contien (
     * se debe agrupar) generalmente estas codnciones vienen con un JSOnQUery
     * (id .eq. @id .and. name .eq. @name) or active .eq.
     * @active
     */
    public static Boolean isValidLogicalOperator(String vForm) {
        Boolean isValid = Boolean.FALSE;
        try {
            switch (vForm) {
                case ".eq.":
                    isValid = Boolean.TRUE;
                    break;
                case ".ne.":
                    isValid = Boolean.TRUE;
                    break;
                case ".lt.":
                    isValid = Boolean.TRUE;
                    break;
                case ".lte.":
                    isValid = Boolean.TRUE;
                    break;
                case ".gt.":
                    isValid = Boolean.TRUE;
                    break;
                case ".gte.":
                    isValid = Boolean.TRUE;
                    break;
                case ".skip.":
                    isValid = Boolean.TRUE;
                    break;
                case ".by.":
                    isValid = Boolean.TRUE;
                    break;

            }
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean compare(String vForm, String operator)">

    /**
     * Compara los valores
     *
     * @param vForm
     * @param operator
     * @return
     */
    public static Boolean compare(String vForm, String operator) {
        Boolean isValid = Boolean.FALSE;
        try {
            if (vForm.equals(operator)) {
                isValid = Boolean.TRUE;
            }
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isValidBooleanOperador(String vForm) ">
    /**
     * Veririca los operadores Booleanos permitodos
     *
     * @param vForm
     * @return
     */
    public static Boolean isValidBooleanOperador(String vForm) {
        Boolean isValid = Boolean.FALSE;
        try {
            switch (vForm) {
                case ".and.":
                    isValid = Boolean.TRUE;
                    break;
                case ".or.":
                    isValid = Boolean.TRUE;
                    break;
                case ".not.":
                    isValid = Boolean.TRUE;
                    break;
                case ".limit.":
                    isValid = Boolean.TRUE;
                    break;
                case ".order.":
                    isValid = Boolean.TRUE;
                    break;

            }
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean isValidSizeComparative(Integer vFormSize, Integer parameterSize)>
    /**
     *
     * @param vFormSize
     * @param parameterSize
     * @return Boolean si los tamaños de parametros y de VForm.where cumplen las
     * reglas
     */
    public static Boolean isValidSizeComparative(Integer vFormSize, Integer parameterSize) {
        Boolean isValid = Boolean.FALSE;
        try {
// vForm incremento de 4
// paramSize incremento de 1
            if ((vFormSize == 3 && parameterSize == 1)
                    || (vFormSize == 7 && parameterSize == 2)
                    || (vFormSize == 11 && parameterSize == 3)
                    || (vFormSize == 15 && parameterSize == 4)
                    || (vFormSize == 19 && parameterSize == 5)) {
                isValid = Boolean.TRUE;
            }
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return isValid;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String  isValidVFormCharacters(VForm vForm, List<? extends VariableElement> parameters, String nameOfMethod)">
    public static String isValidVFormCharacters(VForm vForm, List<? extends VariableElement> parameters, String nameOfMethod) {
        String message = "";
        try {
           
            

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return message;
    }
// </editor-fold>

   

   
    
    // <editor-fold defaultstate="collapsed" desc="Predicate<String> findToken(String token)">

     public static Predicate<String> findToken(String token) {
    return (String l) -> {
      return l.equals(token);
    };
  }
     // </editor-fold>
     
     
     // <editor-fold defaultstate="collapsed" desc=" boolean  nameOfJavaIdentifierValid(String identifier)">
    public static boolean nameOfJavaIdentifierValid(String identifier) {
        try {
            String regex = "^([a-zA-Z_$][a-zA-Z\\d_$]*)$";

            Pattern p = Pattern.compile(regex);

            if (identifier == null) {
                return false;
            }

            Matcher m = p.matcher(identifier);

            return m.matches();
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
        return Boolean.FALSE;
    }
// </editor-fold>

}
