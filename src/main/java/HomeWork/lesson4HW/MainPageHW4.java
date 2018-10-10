package HomeWork.lesson4HW;

public class MainPageHW4 {
//  В проекте создать класс MenuNavigation С помощью языка Xpath и CSS селекторов описать локаторы
//  для веб элементов на странице http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation

    public String homeIconBtnXpath = "//a[@class='home']";
    public String homeIconBtnCss = ".home";

    public String homeIconBtnTitleXpath = "//span[@class='navigation_page']";
    public String homeIconBtnTitleCss = ".navigation_page";

    public String pageTitleXpath = "//h1[@class='page-heading']";
    public String pageTitleCss = ".page-heading";

    public String accountFormXpath = "//form[@id='account-creation_form']";
    public String accountFormCss = "#account-creation_form";

    public String personalInfoSectionTitleXpath1 = "//h3[text()='Your personal information']";
    public String personalInfoSectionTitleXpath2 = "//form[@class='std box']/div[1]/h3";
    public String personalInfoSectionTitleXpath3 = "(//h3[@class='page-subheading'])[1]";
    public String personalInfoSectionTitleCss = "#account-creation_form";

    public String genderTitleXpath = "//label[text()='Title']";
    public String genderTitleCss = ".clearfix > label";

    public String mrGenderRadioButtonXpath = "//input[@id='id_gender1']";
    public String mrGenderRadioButtonCss = "#id_gender1";

    public String mrGenderTitleXpath = "//label[@for='id_gender1']";
    public String mrGenderTitleCss = "label[for='id_gender1']";

    public String mrsGenderRadioButtonXpath = "//input[@id='id_gender2']";
    public String mrsGenderRadioButtonCss = "#id_gender2";

    public String mrsGenderTitleXpath = "//label[@for='id_gender2']";
    public String mrsGenderTitleCss = "label[for='id_gender2']";

    public String firstNameTitleXpath = "//label[@for='customer_firstname']";
    public String firstNameTitleCss = "label[for='customer_firstname']";

    public String firstNameTitleRequiredPointXpath = "//label[@for='customer_firstname']/sup"; //звездочка * обязательного поля
    public String firstNameTitleRequiredPointCss = "label[for='customer_firstname'] sup";

    public String firstNameInputXpath = "//input[@id='customer_firstname']";
    public String firstNameInputCss = "#customer_firstname";

    public String lastNameTitleXpath = "//label[@for='customer_lastname']";
    public String lastNameTitleCss = "label[for='customer_lastname']";

    public String lastNameInputXpath = "//input[@id='customer_lastname']";
    public String lastNameInputCss = "#customer_lastname";

    public String emailTitleXpath = "//label[@for='email']";
    public String emailTitleCss = "label[for='email']";

    public String emailInputXpath = "//input[@id='email']";
    public String emailInputCss = "#email";

    public String passwordTitleXpath = "//label[@for='passwd']";
    public String passwordTitleCss = "label[for='passwd']";

    public String passwordInputXpath = "//input[@id='passwd']";
    public String passwordInputCss = "#passwd";

    public String passwordInputInfoXpath1 = "//span[contains(text(),'Five characters minimum')]";
    public String passwordInputInfoXpath2 = "//div[@class='required password form-group']/span";
    public String passwordInputInfoXpath3 = "(//span[@class='form_info'])[1]";
    public String passwordInputInfoCss = "#passwd";

    public String birthTitleXpath1 = "(//span[@class='form_info'])[1]";
    public String birthTitleXpath2 = "//div[@class='form-group']/label";
    public String birthTitleXpath3 = "(//div[@class='form-group'])[1]/label";
    public String birthTitleCss = ".password + .form-group label";

    public String birthDaysSelectXpath3 = "//select[@id='days']";
    public String birthDaysSelectCss = "#days";

    public String birthDaysSelectFirstOptionXpath3 = "//select[@id='days']/option[1]";
    public String birthDaysSelectFirstOptionCss = "#days option:nth-child(1)"; //#days > option[value='1']

    public String birthMonthsSelectXpath3 = "//select[@id='months']";
    public String birthMonthsSelectCss = "#months";

    public String birthMonthsSelectFirstOptionXpath3 = "//select[@id='months']/option[1]";
    public String birthMonthsSelectFirstOptionCss = "#months option:nth-child(1)";

    public String birthYearsSelectXpath3 = "//select[@id='years']";
    public String birthYearsSelectCss = "#years";

    public String birthYearsSelectFirstOptionXpath3 = "//select[@id='years']/option[1]";
    public String birthYearsSelectFirstOptionCss = "#years option:nth-child(1)";

    public String newsletterCheckboxXpath = "//input[@id='newsletter']";
    public String newsletterCheckboxCss = "#newsletter";

    public String newsletterTitleXpath = "//label[@for='newsletter']";
    public String newsletterTitleCss = "label[for='newsletter']";

    public String specialOffersCheckboxXpath = "//input[@id='optin']";
    public String specialOffersCheckboxCss = "#optin";

    public String specialOffersTitleXpath = "//label[@for='optin']";
    public String specialOffersTitleCss = "label[for='optin']";

    public String yourAddressSectionTitleXpath1 = "//h3[text()='Your address']";
    public String yourAddressSectionTitleXpath2 = "//form[@class='std box']/div[2]/h3";
    public String yourAddressSectionTitleXpath3 = "(//h3[@class='page-subheading'])[2]";
    public String yourAddressSectionTitleCss = ".account_creation:nth-child(2) h3";

    public String firstNameTitleAdressSectionXpath3 = "//label[@for='firstname']";
    public String firstNameTitleAdressSectionTitleCss = "label[for='firstname']";

    public String firstNameTitleAdressSectionRequiredPointXpath = "//label[@for='firstname']/sup"; //звездочка * обязательного поля
    public String firstNameTitleAdressSectionRequiredPointCss = "label[for='firstname'] sup";

    public String firstNameTitleAdressSectionInputXpath = "//input[@id='firstname']";
    public String firstNameTitleAdressSectionInputCss = "#firstname[name='firstname']"; //input[name='firstname']

    public String lastNameTitleAdressSectionXpath = "//label[@for='lastname']";
    public String lastNameTitleAdressSectionCss = "label[for='lastname']";

    public String lastNameInputAdressSectionXpath = "//input[@id='lastname']";
    public String lastNameInputAdressSectionCss = "#lastname[name='lastname']"; //input[name='lastname']

    public String companyTitleXpath = "//label[@for='company']";
    public String companyTitleCss = "label[for='company']";

    public String companyInputXpath = "//input[@id='company']";
    public String companyInputCss = "#company";

    public String addressTitleXpath = "//label[@for='address1']";
    public String addressTitleCss = "label[for='address1']";

    public String addressInputXpath = "//input[@id='address1']";
    public String addressInputCss = "#address1";

    public String addressInputInfoXpath1 = "//span[text()='Street address, P.O. Box, Company name, etc.']";
    public String addressInputInfoXpath2 = "(//span[@class='inline-infos'])[1]";
    public String addressInputInfoCss = "#address1 + .inline-infos";

    public String addressLine2TitleXpath = "//label[@for='address2']";
    public String addressLine2TitleCss = "label[for='address2']";

    public String addressLine2InputXpath = "//input[@id='address2']";
    public String addressLine2InputCss = "#address2";

    public String addressLine2InputInfoXpath1 = "//span[text()='Apartment, suite, unit, building, floor, etc...']";
    public String addressLine2InputInfoXpath2 = "(//span[@class='inline-infos'])[2]";
    public String addressLine2InputInfoCss = "#address2 + .inline-infos";

    public String cityTitleXpath = "//label[@for='city']";
    public String cityTitleCss = "label[for='city']";

    public String cityInputXpath = "//input[@id='city']";
    public String cityInputCss = "#city";

    public String stateTitleXpath = "//label[@for='id_state']";
    public String stateTitleCss = "label[for='id_state']";

    public String stateInputXpath = "//select[@id='id_state']";
    public String stateInputCss = "#id_state";

    public String stateInputFirstOptionXpath = "//select[@id='id_state']/option[1]";
    public String stateInputFirstOptionCss = "#id_state option:nth-child(1)";

    public String postCodeTitleXpath = "//label[@for='postcode']";
    public String postCodeTitleCss = "label[for='postcode']";

    public String postCodeInputXpath = "//input[@id='postcode']";
    public String postCodeInputCss = "#postcode";

    public String countryTitleXpath = "//label[@for='id_country']";
    public String countryTitleCss = "label[for='id_country']";

    public String countryInputXpath = "//select[@id='id_country']";
    public String countryInputCss = "#id_country";

    public String countryInputFirstOptionXpath = "////select[@id='id_country']/option[1]";
    public String countryInputFirstOptionCss = "#id_country option:nth-child(1)";

    public String additionalInfoTitleXpath = "//label[@for='other']";
    public String additionalInfoTitleCss = "label[for='other']";

    public String additionalInfoInputXpath = "//textarea[@id='other']";
    public String additionalInfoInputCss = "#other";

    public String additionalInfoInputInfoXpath = "//p[@class='inline-infos']";
    public String additionalInfoInputInfoCss = "p.inline-infos']";

    public String homePhoneTitleXpath = "//label[@for='phone']";
    public String homePhoneTitleCss = "label[for='phone']";

    public String homePhoneInputXpath = "//input[@id='phone']";
    public String homePhoneInputCss = "#phone";

    public String mobilePhoneTitleXpath = "//label[@for='phone_mobile']";
    public String mobilePhoneTitleCss = "label[for='phone_mobile']";

    public String mobilePhoneInputXpath = "//input[@id='phone_mobile']";
    public String mobilePhoneInputCss = "#phone_mobile";

    public String addressAliasTitleXpath = "//label[@for='alias']]";
    public String addressAliasTitleCss = "label[for='alias']";

    public String addressAliasInputXpath = "//input[@id='alias']";
    public String addressAliasInputCss = "#alias";

    public String submitAccountButtonXpath = "//button[@id='submitAccount']";
    public String submitAccountButtonCss = "#submitAccount";

    public String submitAccountButtonTextXpath = "//button[@id='submitAccount']/span";
    public String submitAccountButtonTextCss = "#submitAccount span";

    public String submitAccountButtonArrowXpath = "//button[@id='submitAccount']/span/i";
    public String submitAccountButtonArrowTextCss = "#submitAccount .icon-chevron-right";

    public String requiredTextXpath = "//p[@class='pull-right required']";
    public String requiredTextCss = ".pull-right";
}


