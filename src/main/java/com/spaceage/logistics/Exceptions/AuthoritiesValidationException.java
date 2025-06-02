package com.spaceage.logistics.Exceptions;

import java.util.List;

public class AuthoritiesValidationException extends RuntimeException {

        private List<String> errors;

        public AuthoritiesValidationException(List<String> errors) {
            super("Authorities errors occurred");
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }

}
