package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.U_IS_NOT_ACCESSIBLE_NOW);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.U_IS_NOT_ACCESSIBLE_NOW, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.U_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.U_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.U_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.U_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.A_IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.A_IS_DENIED, cause);
        }
    }

    public final static class Constants {
        static final String A_IS_DENIED = "Access is denied.";
        static final String U_IS_BANNED = "User is banned.";
        static final String U_IS_NOT_AUTHORIZED = "User is not authorized.";
        static final String U_IS_NOT_ACCESSIBLE_NOW = "Server is not accessible for now.";

    }
}
