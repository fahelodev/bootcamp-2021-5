package katas.bfuentes;

    public class sortCsvColumns
    {
        public static String sortCsvColumns(String csvFileContent)
        {
            System.out.println("before " + csvFileContent);
            String[] filas = csvFileContent.split("\n");
            StringBuilder s = new StringBuilder();
            String[] fila = filas[0].split(";");
            int[] orden = new int[fila.length];
            for(int i =0; i< orden.length;i++){
                orden[i] = i;
            }
            for(int k=0;k<(fila.length-1);k++){
                for(int j=k+1;j<fila.length;j++){
                    if(fila[k].compareToIgnoreCase(fila[j])>0){
                        String variableauxiliar=fila[k];
                        fila[k]=fila[j];
                        fila[j]=variableauxiliar;
                        int variableaux=orden[k];
                        orden[k]=orden[j];
                        orden[j]=variableaux;
                    }
                }
            }
            for(int i =0; i< orden.length;i++){
                System.out.println("after " + orden[i]);
            }
            for(int i =0; i< filas.length;i++){
                fila = filas[i].split(";");
                for(int j =0; j< orden.length;j++){
                    if (j != orden.length-1){
                        s.append(fila[orden[j]] + ";");
                    } else {
                        s.append(fila[orden[j]]);
                    }
                }
                if (i != filas.length-1){
                    s.append("\n");
                }
            }

            System.out.println("after " + s.toString());
            return s.toString();
        }
    }

