/**
 * @description Clase ObjetoComicDTO que contiene la informacion de un comic
 * 
 * @author Lenin Narvaez Martinez <ljnarvaez@gmail.com>
 */

export class ObjetoComicDTO {
    
    /**
    * Variable publica que mostrara el id del Comic.
    */
    id : Number;

    /**
    * Variable publica que mostrara el nombre del Comic.
    */
    nombre : String;

    /**
    * Variable publica que mostrara la editorial del Comic.
    */
    editorial : String;

    /**
    * Variable publica que mostrara la tematica del Comic.
    */
    tematica : String;

    /**
    * Variable publica que mostrara el numero de paginas del Comic.
    */
    numeroPaginas : Number;

    /**
    * Variable publica que mostrara el precio del Comic.
    */
    precio : Number;

    /**
    * Variable publica que mostrara el autor del Comic.
    */
    autores : String;

    /**
    * Variable publica que mostrara el color del Comic.
    */
    aColor : Boolean;

    /**
    * Variable publica que mostrara la fecha de lanzamiento del Comic.
    */
    fechaVenta : String;

    /**
    * Variable publica que mostrara el estado del Comic.
    */
    estado : String
};