package qtx.test.time;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Test_JavaTime {
	

	public static void main(String[] args) {
		testLocalDate();
//		testLocalTime();
//		testInstantYDuration();
//		testLocalDateTime();
	}

	private static void testLocalDateTime() {
		Date fechaJava01 = new Date();
		LocalDateTime ldcFechaJava8 = toLocalDateTime(fechaJava01);
		System.out.println(ldcFechaJava8);
		
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
		System.out.println(formateador.format(ldcFechaJava8));
		
		LocalDateTime ldtFecNac = LocalDateTime.parse("11/01/1968 11:10:15 a.m.", formateador);
		System.out.println(formateador.format(ldtFecNac));
	}

	private static void testInstantYDuration() {
		NumberFormat nf = NumberFormat.getNumberInstance();

		Instant inicio = Instant.now();
		hacerPausaAleatoria(4);
		Instant fin = Instant.now();
	   	
		// Duration maneja por separado los segundos y los nanosegundos de la duración
		Duration duracionPausa = Duration.between(inicio, fin);
		System.out.println("Pausa: " + duracionPausa);
		System.out.print("Pausa " + duracionPausa.getSeconds() + " segundo(s) " );
		System.out.println("con " + nf.format(duracionPausa.getNano())
				                  + " nanosegundos -milmillonésimas de segundo-)" );
		System.out.println("Pausa (en milisegundos): " + duracionPausa.toMillis() );
		System.out.println("Pausa (en nanosegundos): " + nf.format(duracionPausa.toNanos()) );
		
	}

	private static void hacerPausaAleatoria(int hastaNseg) {
		long milisPausa = Math.round((Math.random() * 10000000)) % (hastaNseg * 1000);
		try {
			Thread.sleep(milisPausa);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void testLocalDate() {
		// Creación de fechas
		LocalDate fechaDescubrimientoAmerica = LocalDate.of(1492, 10, 12);
		LocalDate fechaIndependencia = LocalDate.of(1810, Month.SEPTEMBER, 15);
		LocalDate hoy = LocalDate.now();
		
		// Datos de las fechas
		System.out.println("América se descubrió el " + fechaDescubrimientoAmerica.toString());
		System.out.println("Hoy es " + hoy);
		System.out.println("El dia de la independencia fue un " + fechaIndependencia.getDayOfWeek().name());
		
		//Cálculo de fechas
		LocalDate fecha2mesesAdelante = hoy.plusMonths(2);
		System.out.println("En 2 meses será: " + fecha2mesesAdelante);
		System.out.println("Hace 37 días era: " + hoy.minusDays(37));
		
		//Chequeos de fechas
		if(hoy.isBefore(fecha2mesesAdelante))
			System.out.println(hoy + " es ANTES de " + fecha2mesesAdelante);
		else
			System.out.println(hoy + " no es ANTES de " + fecha2mesesAdelante);
		
		//Periodos de tiempo	
		Period tiempoTranscurrido = fechaIndependencia.until(hoy);
		Period tiempoTranscurrido2 = hoy.until(fechaIndependencia);
		System.out.println("Tiempo trancurrido entre la independencia y hoy :" + tiempoTranscurrido);
		System.out.println(tiempoTranscurrido.getYears() + " años");
		System.out.println(tiempoTranscurrido.getMonths() + " meses");
		System.out.println(tiempoTranscurrido.getDays() + " días");
		
		System.out.println("Tiempo trancurrido entre hoy y la independencia :" + tiempoTranscurrido2);
	}
	public static void testLocalTime() {
		LocalTime horaLevantarse = LocalTime.of(6, 10, 5);
		System.out.println("La hora de levantarse es " + horaLevantarse);
		
		LocalTime antes = LocalTime.now();
		LocalTime despues = LocalTime.now();
		System.out.println("antes = " + antes);
		System.out.println("despues = " + despues);
		
		LocalTime masTarde = antes.plus(30, ChronoUnit.MINUTES);
	    masTarde = masTarde.plus(4550, ChronoUnit.NANOS);
		System.out.println("masTarde = " + masTarde);
		
		long segundos = antes.until(masTarde, ChronoUnit.SECONDS);
		long miliSegundos = antes.until(masTarde, ChronoUnit.MILLIS);
		long nanoSegundos = antes.until(masTarde, ChronoUnit.NANOS);
		System.out.println("Segundos transcurridos entre antes y masTarde = " + segundos);
		System.out.println("Milisegundos transcurridos entre antes y masTarde = " + miliSegundos);
		System.out.println("Nanosegundos transcurridos entre antes y masTarde = " + nanoSegundos);
	
		//Chequeos de fechas
		if(antes.isBefore(masTarde))
			System.out.println(antes + " es ANTES de " + masTarde);
		else
			System.out.println(antes + " no es ANTES de " + masTarde);
		
	}
	public static LocalDateTime toLocalDateTime(Date fecha) {
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(fecha);
		LocalDateTime ldtFecha = LocalDateTime.of(gCal.get(Calendar.YEAR),
				                                  gCal.get(Calendar.MONTH) + 1,
				                                  gCal.get(Calendar.DAY_OF_MONTH),
				                                  gCal.get(Calendar.HOUR_OF_DAY),
				                                  gCal.get(Calendar.MINUTE),
				                                  gCal.get(Calendar.SECOND)
				                                  );
		return ldtFecha;
	}
}
