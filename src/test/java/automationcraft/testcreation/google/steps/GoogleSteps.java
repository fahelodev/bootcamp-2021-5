package automationcraft.testcreation.google.steps;


import io.cucumber.java.en.*;

public class GoogleSteps {

    public class VF_step_definitions {

        @Given("estoy en un navegador con la pagina inicial de google")
        public void estoy_en_un_navegador_con_la_pagina_inicial_de_google() {
            System.out.println("Hola");
        }

        @When("introduzco la palabra {string} en la barra")
        public void introduzco_la_palabra_en_la_barra(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @When("realizo la busqueda con Enter")
        public void realizo_la_busqueda_con_enter() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @Then("el navegador me muestra los resultados")
        public void el_navegador_me_muestra_los_resultados() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }

        @When("realizo la busqueda con el boton {string}")
        public void realizo_la_busqueda_con_el_boton(String string) {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }


    }
}
