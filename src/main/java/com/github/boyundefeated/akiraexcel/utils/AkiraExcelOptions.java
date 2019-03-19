package com.github.boyundefeated.akiraexcel.utils;

import static com.github.boyundefeated.akiraexcel.utils.AkiraExcelConstants.DEFAULT_DATE_PATTERN;
import static com.github.boyundefeated.akiraexcel.utils.AkiraExcelConstants.DEFAULT_DATE_TIME_FORMATTER;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.github.boyundefeated.akiraexcel.config.Casting;
import com.github.boyundefeated.akiraexcel.config.DefaultCasting;
import com.github.boyundefeated.akiraexcel.exception.AkiraExcelException;

public final class AkiraExcelOptions {

    private int skip;
    private int sheetIndex;
    private String password;
    private String dateRegex;
    private String datePattern;
    private boolean dateLenient;
    private boolean trimCellValue;
    private boolean ignoreHiddenSheets;
    private boolean preferNullOverDefault;
    private DateTimeFormatter dateTimeFormatter;
    private Casting casting;
    private int headerStart;

    private AkiraExcelOptions() {
        super();
    }

    private AkiraExcelOptions setSkip(int skip) {
        this.skip = skip;
        return this;
    }

    private AkiraExcelOptions setDatePattern(String datePattern) {
        this.datePattern = datePattern;
        return this;
    }

    private AkiraExcelOptions setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
        return this;
    }

    private AkiraExcelOptions setPreferNullOverDefault(boolean preferNullOverDefault) {
        this.preferNullOverDefault = preferNullOverDefault;
        return this;
    }

    public String getPassword() {
        return password;
    }

    private AkiraExcelOptions setPassword(String password) {
        this.password = password;
        return this;
    }

    public String datePattern() {
        return datePattern;
    }

    public DateTimeFormatter dateTimeFormatter() {
        return dateTimeFormatter;
    }

    public boolean preferNullOverDefault() {
        return preferNullOverDefault;
    }

    /**
     * the number of skipped rows
     *
     * @return n rows skipped
     */
    public int skip() {
        return skip;
    }

    public boolean ignoreHiddenSheets() {
        return ignoreHiddenSheets;
    }

    private AkiraExcelOptions setIgnoreHiddenSheets(boolean ignoreHiddenSheets) {
        this.ignoreHiddenSheets = ignoreHiddenSheets;
        return this;
    }

    public boolean trimCellValue() {
        return trimCellValue;
    }

    public AkiraExcelOptions setTrimCellValue(boolean trimCellValue) {
        this.trimCellValue = trimCellValue;
        return this;
    }

    public Casting getCasting() {
        return casting;
    }

    public AkiraExcelOptions setCasting(Casting casting) {
        this.casting = casting;
        return this;
    }

    private AkiraExcelOptions setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
        return this;
    }

    public int sheetIndex() {
        return sheetIndex;
    }

    public String getDateRegex() {
        return dateRegex;
    }

    private AkiraExcelOptions setDateRegex(String dateRegex) {
        this.dateRegex = dateRegex;
        return this;
    }

    public boolean getDateLenient() {
        return dateLenient;
    }

    private AkiraExcelOptions setDateLenient(boolean dateLenient) {
        this.dateLenient = dateLenient;
        return this;
    }

    public int getHeaderStart() {
        return headerStart;
    }

    private AkiraExcelOptions setHeaderStart(int headerStart) {
        this.headerStart = headerStart;
        return this;
    }

    public static class AkiraExcelOptionsBuilder {

        private int sheetIndex;
        private String password;
        private String dateRegex;
        private boolean dateLenient;
        private boolean trimCellValue;
        private boolean ignoreHiddenSheets;
        private boolean preferNullOverDefault;
        private String datePattern = DEFAULT_DATE_PATTERN;
        private DateTimeFormatter dateTimeFormatter = DEFAULT_DATE_TIME_FORMATTER;
        private Casting casting = new DefaultCasting();
        private int headerStart = 0;
        private int skip = 0;

        private AkiraExcelOptionsBuilder() {
        }

        private AkiraExcelOptionsBuilder(int skip) {
            this.skip = skip;
        }

        /**
         * Skip a number of rows after the header row. The header row is not counted.
         *
         * @param skip ignored row number after the header row
         * @return builder itself
         */
        public static AkiraExcelOptionsBuilder settings(int skip) {
            if (skip < 0) {
                throw new AkiraExcelException("Skip index must be greater than or equal to 0");
            }
            return new AkiraExcelOptionsBuilder(skip);
        }

        public static AkiraExcelOptionsBuilder settings() {
            return new AkiraExcelOptionsBuilder();
        }

        /**
         * set a date time formatter, default date time formatter is "dd/M/yyyy"
         * for java.time.LocalDate
         *
         * @param dateTimeFormatter date time formatter
         * @return this
         */
        public AkiraExcelOptionsBuilder dateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
            return this;
        }

        /**
         * set date pattern, default date format is "dd/M/yyyy" for
         * java.util.Date
         *
         * @param datePattern date time formatter
         * @return this
         */
        public AkiraExcelOptionsBuilder datePattern(String datePattern) {
            this.datePattern = datePattern;
            return this;
        }

        /**
         * set whether or not to use null instead of default values for Integer,
         * Double, Float, Long, String and java.util.Date types.
         *
         * @param preferNullOverDefault boolean
         * @return this
         */
        public AkiraExcelOptionsBuilder preferNullOverDefault(boolean preferNullOverDefault) {
            this.preferNullOverDefault = preferNullOverDefault;
            return this;
        }

        public AkiraExcelOptions build() {
            return new AkiraExcelOptions()
                    .setSkip(skip + headerStart + 1)
                    .setPassword(password)
                    .setPreferNullOverDefault(preferNullOverDefault)
                    .setDatePattern(datePattern)
                    .setDateTimeFormatter(dateTimeFormatter)
                    .setSheetIndex(sheetIndex)
                    .setIgnoreHiddenSheets(ignoreHiddenSheets)
                    .setTrimCellValue(trimCellValue)
                    .setDateRegex(dateRegex)
                    .setDateLenient(dateLenient)
                    .setHeaderStart(headerStart)
                    .setCasting(casting);
        }

        /**
         * set sheet index, default is 0
         *
         * @param sheetIndex number
         * @return this
         */
        public AkiraExcelOptionsBuilder sheetIndex(int sheetIndex) {
            if (sheetIndex < 0) {
                throw new AkiraExcelException("Sheet index must be greater than or equal to 0");
            }
            this.sheetIndex = sheetIndex;
            return this;
        }

        /**
         * skip a number of rows after the header row. The header row is not counted.
         *
         * @param skip number
         * @return this
         */
        public AkiraExcelOptionsBuilder skip(int skip) {
            if (skip < 0) {
                throw new AkiraExcelException("Skip index must be greater than or equal to 0");
            }
            this.skip = skip;
            return this;
        }

        /**
         * set password for encrypted excel file, Default is null
         *
         * @param password password of excel file
         * @return this
         */
        public AkiraExcelOptionsBuilder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * Ignore hidden sheets
         *
         * @param ignoreHiddenSheets whether or not to ignore any hidden sheets
         *                           in the work book.
         * @return this
         */
        public AkiraExcelOptionsBuilder ignoreHiddenSheets(boolean ignoreHiddenSheets) {
            this.ignoreHiddenSheets = ignoreHiddenSheets;
            return this;
        }

        /**
         * Trim cell value
         *
         * @param trimCellValue trim the cell value before processing work book.
         * @return this
         */
        public AkiraExcelOptionsBuilder trimCellValue(boolean trimCellValue) {
            this.trimCellValue = trimCellValue;
            return this;
        }

        /**
         * Date regex, if would like to specify a regex patter the date must be
         * in, e.g.\\d{2}/\\d{1}/\\d{4}.
         *
         * @param dateRegex date regex pattern
         * @return this
         */
        public AkiraExcelOptionsBuilder dateRegex(String dateRegex) {
            this.dateRegex = dateRegex;
            return this;
        }

        /**
         * If the simple date format is lenient, use to
         * set how strict the date formatting must be, defaults to lenient false.
         * It works only for java.util.Date.
         *
         * @param dateLenient true or false
         * @return this
         */
        public AkiraExcelOptionsBuilder dateLenient(boolean dateLenient) {
            this.dateLenient = dateLenient;
            return this;
        }

        /**
         * Use a custom casting implementation
         *
         * @param casting custom casting implementation
         * @return this
         */
        public AkiraExcelOptionsBuilder withCasting(Casting casting) {
            Objects.requireNonNull(casting);

            this.casting = casting;
            return this;
        }

        /**
         * This is to set the row which the unmarshall will
         * use to start reading header titles, incase the
         * header is not in row 0.
         *
         * @param headerStart an index number of the excel header to start reading header
         * @return this
         */
        public AkiraExcelOptionsBuilder headerStart(int headerStart) {
            if (headerStart < 0) {
                throw new AkiraExcelException("Header index must be greater than or equal to 0");
            }
            this.headerStart = headerStart;
            return this;
        }
    }

}
