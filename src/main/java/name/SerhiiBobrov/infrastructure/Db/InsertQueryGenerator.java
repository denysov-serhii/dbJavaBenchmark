package name.SerhiiBobrov.infrastructure.Db;

class InsertQueryGenerator {
    String generate(String table, String[] fields) {
        String fieldsAsString = String.join(",", fields);

        StringBuilder placeholders = new StringBuilder();

        for (int i = 0; i < fields.length; i++) {
            placeholders.append('?');

            if (i != fields.length - 1) {
                placeholders.append(',');
            }
        }

        return String.format( "INSERT INTO %s (%s) VALUES (%s)", table, fieldsAsString, placeholders);
    }
}
