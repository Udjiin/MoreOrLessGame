package com.company;

import java.util.Scanner;

public class Controller {



    private Model model;
    private View view;

  public Controller(Model model,View view){
      this.model=model;
      this.view=view;
  }

  public void userProcess()
  {
      Scanner sc=new Scanner(System.in);
      model.setPrimaryBarrier(view.MIN_NUMBER,view.MAX_NUMBER);
      model.setSecretNumber();


      view.printMessage(view.GAME_NAME);
      view.printMessage(view.GAME_SENSE);

      while (model.checkValue(inputSupposedNumber(sc)));

      view.printMessage(view.WIN);
      view.printMessage(view.SECRET_NUMBER_WAS+model.getSecretNumber());
      view.printMessage(view.TRY_INFO+String.valueOf(model.getYourWay()));
  }
public int inputSupposedNumber(Scanner sc) {
    int res = 0;
    view.printMessage(view.INPUT_INT_NUMBER+String.valueOf(model.getMinNumber())+view.HYPHEN
            +String.valueOf(model.getMaxNumber())+view.DIAPASON);
    while (true) {
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT + " \n" + view.INPUT_INT_NUMBER+String.valueOf(model.getMinNumber())+
                    view.HYPHEN +String.valueOf(model.getMaxNumber())+view.DIAPASON);
            sc.next();
        }
        if ((res = sc.nextInt()) <= model.getMinNumber() || res >= model.getMaxNumber()) {
            view.printMessage(view.WRONG_DIAPOSON+String.valueOf(model.getMinNumber())+
                    view.HYPHEN +String.valueOf(model.getMaxNumber())+view.DIAPASON+ " \n" + view.INPUT_INT_NUMBER+String.valueOf(model.getMinNumber())+
                    view.HYPHEN +String.valueOf(model.getMaxNumber())+view.DIAPASON);
            continue;
        }
        break;
    }
    return res;
    }
}



