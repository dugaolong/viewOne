package com.dgl.通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 18/5/9.
 */

public interface Person {
   void eat();
}


class F{



   public void per(List<? extends Person> list) {//上边界
      for (Person person : list) {
         person.eat();
      }
   }
   public void man(){
      List<? super Man> sList = null;//下边界
      sList = new ArrayList<Person>();
   }



}