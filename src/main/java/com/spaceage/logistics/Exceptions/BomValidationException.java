package com.spaceage.logistics.Exceptions;

import java.util.List;

public class BomValidationException extends RuntimeException {

        private List<String> errors;

        public BomValidationException(List<String> errors) {
            super("Validation errors occurred");
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }

}
