package com.iamsajan.book.email;

public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activation_account");

    private final String templateName;

    EmailTemplateName(String templateName) {
        this.templateName = templateName;
    }

}

