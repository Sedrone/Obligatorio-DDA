static void agregarJugador() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
        System.out.println("Ingrese los datos del jugador " + (i + 1) + ":");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        listaPersonas.add(new Persona(nombre, apellido, edad));
        }

        mostrarListaPersonas();
        }