addressbook - simple contact manager
============================================================================================================================================


####ABRSTRACT

Simple contact manager that enables you to store and find your contact information. You can also add multiple addresses to your contact.

####AUTHORS

*Nerojan Rajaratnam*

<rajaratnam@et.esiea.fr>

*Quentin Chouleur* 

<chouleur@et.esiea.fr>



####CREDITS

- [font awesome](http://fontawesome.io) - Set of scalable vector icons created by Dave Gandy. licensed under the *SIL OFL 1.1*.

- [Bootstrap](http://getbootstrap.com) - HTML, CSS & JS framwork. *MIT License*.

- [Bootplus](http://aozora.github.io/bootplus/) - Enhanced bootstrap with a google-ish style. *Apache License v2.0*.


####DESCRIPTION

Nous avons réalisé une application qui gère des contactes avec leurs adresses (livraison et facturation). Pour se faire, nous avons utilisé le framework Spring MVC

et avons déployé l'application sur Google AppEngine (URL: addressbook-esiea.appspot.com).

L'application dispose de deux IHM, un pour les contacts et l'autre pour les adresses qui se traduisent par deux contrôleurs ainsi que de 6 pages JSP.

####Utilisation

![Alt text](/src/main/webapp/resources/screenshots/desc_contact.png?raw=true "Contacts")

![Alt text](/src/main/webapp/resources/screenshots/desc_address.png?raw=true "Addresses")

###Spring MVC

« SPRING est effectivement un conteneur dit “ léger ”, c’est-à-dire une infrastructure similaire à un serveur d'applications J2EE. Il prend donc en charge la création d’objets et la mise en relation d’objets par l’intermédiaire d’un fichier de configuration qui décrit les objets à fabriquer et les relations de dépendances entre ces objets. Le gros avantage par rapport aux serveurs d’application est qu’avec SPRING, les classes n’ont pas besoin d’implémenter une quelconque interface pour être prises en charge par le framework (au contraire des serveur d'applications J2EE et des EJBs). C’est en ce sens que SPRING est qualifié de conteneur “ léger ”. »

Spring s’appuie principalement sur l’intégration de trois concepts clés :

l’inversion de contrôle est assurée de deux façons différentes : la recherche de dépendances et l'injection de dépendances
la programmation orientée aspect
une couche d’abstraction.
La couche d’abstraction permet d’intégrer d’autres frameworks et bibliothèques avec une plus grande facilité. Cela se fait par l’apport ou non de couches d’abstraction spécifiques à des frameworks particuliers. Il est ainsi possible d’intégrer un module d’envoi de mails plus facilement.

Source: Wikipedia





