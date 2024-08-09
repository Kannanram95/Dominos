package org.step;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.base.BaseClass;
import org.pom.DomPo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDomino extends BaseClass {
	public static int ratefarm,qtyfarm,rateMarg,qtyMarg,ratepaneer,qtypaneer,total,subTotal,ratepepsi,qtypepsi;
	DomPo dom = new DomPo();
	@Given("the user in the login page")
	public void the_user_in_the_login_page() {
		tolaunchUrl("https://www.dominos.co.in/");
	}
	@Given("the user click the Order Online now")
	public void the_user_click_the_order_online_now() {
		
		toClick(dom.btnOrderOnline);
	}
	@When("the user click the enter the address textbox")
	public void the_user_click_the_enter_the_address_textbox() {
		toClick(dom.selectAddr);
	}
	@When("the user enters pincode")
	public void the_user_enters_pincode() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2));
		implicitWait();
		tofillText(dom.enterAddr,"600100");
	}
	@When("the user select the first suggestion")
	public void the_user_select_the_first_suggestion() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(5));
		implicitWait();
		toClick(dom.locSuggest);
	}
	@Then("the user go to veg pizza section")
	public void the_user_go_to_veg_pizza_section() throws InterruptedException {
		implicitWait();
		toClick(dom.dontloc);
		Thread.sleep(Duration.ofSeconds(2));
		implicitWait();
		toScrollDown(dom.category("Veg Pizza"));
	}
	@Then("the user select the addcart in Farmhouse pizza")
	public void the_user_select_the_addcart_in_farmhouse_pizza() {
		implicitWait();
		toClick(dom.prodSelect("Veg Pizza","Farmhouse"));
		implicitWait();
		toClick(dom.noThanks);
		ratefarm = get(dom.getrate("Farmhouse"));
	}
	@Then("the user increase the qty of Farmhouse pizza to two")
	public void the_user_increase_the_qty_of_farmhouse_pizza_to_two() {
		toClick(dom.qtyalter("Farmhouse","increase"));
		qtyfarm = get(dom.getqty("Farmhouse"));
	}
	@Then("the user select the addcart in Margherita pizza")
	public void the_user_select_the_addcart_in_margherita_pizza() {
		toClick(dom.prodSelect("Veg Pizza","Margherita"));
		rateMarg = get(dom.getrate("Margherita"));
	}
	@Then("the user increase the qty of Margherita pizza to two")
	public void the_user_increase_the_qty_of_margherita_pizza_to_two() {
		toClick(dom.qtyalter("Margherita","increase"));
		qtyMarg = get(dom.getqty("Margherita"));
	}
	@Then("the user select the addcart in Peppy Paneer pizza")
	public void the_user_select_the_addcart_in_peppy_paneer_pizza() {
		toClick(dom.prodSelect("Veg Pizza","Peppy Paneer"));
		implicitWait();
		ratepaneer = get(dom.getrate("Peppy Paneer"));
	}
	@Then("the user increase the qty of Peppy Paneer pizza to two")
	public void the_user_increase_the_qty_of_peppy_paneer_pizza_to_two() {
		toScrollDown(dom.qtyalter("Peppy Paneer","increase"));
		implicitWait();
		toClick(dom.qtyalter("Peppy Paneer","increase"));
		qtypaneer = get(dom.getqty("Peppy Paneer"));
	}
	@Then("take screenshot and get checkout")
	public void take_screenshot_and_click_checkout() throws IOException {
		screenShot("Screenshot");
		subTotal= get(dom.subTotal);
	}
	@Then("sum the product values based on qty")
	public void sum_the_product_values_based_on_qty() {
		total = (ratefarm*qtyfarm)+(rateMarg*qtyMarg)+(ratepaneer*qtypaneer)+(ratepepsi*qtypepsi);
	}
	@Then("assert the sum with subtotal value")
	public void assert_the_sum_with_subtotal_value() throws InterruptedException {
		subTotal= get(dom.subTotal);
		assertEquals(total, subTotal);
		
	}
	@Given("the user in the menu page")
	public void the_user_in_the_menu_page() {
		
	}
	@Given("the user select the addcart in Pepsi")
	public void the_user_select_the_addcart_in_pepsi() {
		implicitWait();
		toScrollDown(dom.category("Beverages"));
		toClick(dom.prodSelect("Beverages","Pepsi 475ml"));
		ratepepsi = get(dom.getrate("Pepsi 475ml"));
	}
	@When("the user increase the qty in pepsi")
	public void the_user_increase_the_qty_in_pepsi() {
		toScrollDown(dom.qtyalter("Pepsi 475ml","increase"));
		while(get(dom.getqty("Pepsi 475ml"))<12) {
			toClick(dom.qtyalter("Pepsi 475ml","increase"));
		}
		qtypepsi = get(dom.getqty("Pepsi 475ml"));
	}
	@When("the user decrease the qty in Margherita")
	public void the_user_decrease_the_qty_in_margherita() {
		implicitWait();
		toScrollDown(dom.qtyalter("Margherita","increase"));
		toClick(dom.qtyalter("Margherita","decrease"));
		qtyMarg = get(dom.getqty("Margherita"));
	}
	@When("the user decrease the qty in pepsi")
	public void the_user_decrease_the_qty_in_pepsi() {
		toScrollDown(dom.qtyalter("Pepsi 475ml","increase"));
		while(get(dom.getqty("Pepsi 475ml"))>6) {
			toClick(dom.qtyalter("Pepsi 475ml","decrease"));
		}
		qtypepsi = get(dom.getqty("Pepsi 475ml"));
	}
	
}
