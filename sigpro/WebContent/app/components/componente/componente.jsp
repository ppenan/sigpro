<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <style>
		.event_title {
			font-size: 14px;
			font-weight: bold;
		}
		
		.posicion{
			margin-left: -155px;
		}
	</style>
	<%@ page import="org.apache.shiro.SecurityUtils" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<div ng-controller="componenteController as componentec" class="maincontainer all_page" id="title">
		<script type="text/ng-template" id="map.html">
        <div class="modal-header">
            <h3 class="modal-title">Mapa de Ubicación</h3>
        </div>
        <div class="modal-body" style="height: 400px;">
            			<ui-gmap-google-map id="mainmap" ng-if="refreshMap" center="map.center" zoom="map.zoom" options="map.options" events="map.events"  >
							<ui-gmap-marker idkey="1" coords="posicion"></ui-gmap-marker>
						</ui-gmap-google-map>
		</div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
        </div>
    </script>
    
	    <script type="text/ng-template" id="buscarPorComponente.jsp">
    		<%@ include file="/app/components/componente/buscarPorComponente.jsp"%>
  	    </script>
  	    <shiro:lacksPermission name="5010">
			<p ng-init="componentec.redireccionSinPermisos()"></p>
		</shiro:lacksPermission>
		
		<div class="panel panel-default">
			<div class="panel-heading"><h3>Componentes</h3></div>
		</div>
		<div class="subtitulo">
			{{ componentec.objetoTipoNombre }} {{ componentec.proyectoNombre }}
		</div>
		
		<div  align="center" ng-hide="componentec.mostraringreso">
			
    		<div class="operation_buttons" align="right">
			  <div class="btn-group">
			  <shiro:hasPermission name="5040">
			    <label class="btn btn-primary" ng-click="componentec.nuevo()" uib-tooltip="Nuevo">
			    <span class="glyphicon glyphicon-plus"></span> Nuevo</label>
			  </shiro:hasPermission>
			  <shiro:hasPermission name="5010">
			    <label class="btn btn-primary" ng-click="componentec.editar()" uib-tooltip="Editar">
			    <span class="glyphicon glyphicon-pencil"></span> Editar</label>
			  </shiro:hasPermission>
			  <shiro:hasPermission name="5030">
			    <label class="btn btn-danger" ng-click="componentec.borrar()" uib-tooltip="Borrar">
			    <span class="glyphicon glyphicon-trash"></span> Borrar</label>
			  </shiro:hasPermission>
			  </div>
			</div>
    		<shiro:hasPermission name="5010">
    		<div class="col-sm-12" align="center">
    			<div style="height: 35px;">
					<div style="text-align: right;"><div class="btn-group" role="group" aria-label="">
						<a class="btn btn-default" href ng-click="componentec.reiniciarVista()" role="button" uib-tooltip="Reiniciar la vista de la tabla" tooltip-placement="left"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
					</div>
					</div>
				</div>
				<br/>
				<div id="maingrid" ui-grid="componentec.gridOptions" ui-grid-save-state
						ui-grid-move-columns ui-grid-resize-columns ui-grid-selection ui-grid-pinning ui-grid-pagination class="grid">
					<div class="grid_loading" ng-hide="!componentec.mostrarcargando">
				  	<div class="msg">
				      <span><i class="fa fa-spinner fa-spin fa-4x"></i>
						  <br /><br />
						  <b>Cargando, por favor espere...</b>
					  </span>
					</div>
				  </div>
				</div>
				<br/>
			<div class="total-rows">Total de {{  componentec.totalComponentes + (componentec.totalComponentes == 1 ? " Componente" : " Componentes" ) }}</div>
				<ul uib-pagination total-items="componentec.totalComponentes"
						ng-model="componentec.paginaActual"
						max-size="componentec.numeroMaximoPaginas"
						items-per-page="componentec.elementosPorPagina"
						first-text="Primero"
						last-text="Último"
						next-text="Siguiente"
						previous-text="Anterior"
						class="pagination-sm" boundary-links="true" force-ellipses="true"
						ng-change="componentec.cambioPagina()"
				></ul>
			</div>
    		</shiro:hasPermission>

		</div>
		<div class="row second-main-form" ng-show="componentec.mostraringreso">
			<div class="page-header">
				<h2 ng-hide="!componentec.esnuevo"><small>Nuevo componente</small></h2>
				<h2 ng-hide="componentec.esnuevo"><small>Edición de componente</small></h2>
			</div>
			
    		<div class="operation_buttons">
    		  <div class="btn-group" ng-hide="componentec.esnuevo">
				<label class="btn btn-default" ng-click="componentec.irAProductos(componentec.componente.id)" uib-tooltip="Productos" tooltip-placement="bottom">
				<span class="glyphicon glyphicon-certificate"></span></label>
				<label class="btn btn-default" ng-click="componentec.irARiesgos(componentec.componente.id)" uib-tooltip="Riesgos" tooltip-placement="bottom">
				<span class="glyphicon glyphicon-warning-sign"></span></label>
				<label class="btn btn-default" ng-click="componentec.irAActividades(componentec.componente.id)" uib-tooltip="Actividades" tooltip-placement="bottom">
				<span class="glyphicon glyphicon-th-list"></span></label>
			
		      </div>
			  <div class="btn-group" style="float: right;">
			    <shiro:hasPermission name="5020">
			      <label class="btn btn-success" ng-click="form.$valid ? componentec.guardar() : ''" ng-disabled="!form.$valid" title="Guardar">
			      <span class="glyphicon glyphicon-floppy-saved"></span> Guardar</label>
			    </shiro:hasPermission>
			    <label class="btn btn-primary" ng-click="componentec.irATabla()" title="Ir a Tabla">
			    <span class="glyphicon glyphicon-list-alt"></span> Ir a Tabla</label>
			  </div>
			</div>

			<div class="col-sm-12">
				<form name="form" id="form">
						<div class="form-group">
						  <label for="id" class="floating-label">ID {{ componentec.componente.id }}</label>
						  <br/><br/>
						</div>
						
						<div class="form-group">
						   <input type="text" name="nombre"  class="inputText" id="nombre" 
						     ng-model="componentec.componente.nombre" ng-value="componentec.componente.nombre"   
						     onblur="this.setAttribute('value', this.value);" ng-required="true" >
						   <label class="floating-label">* Nombre</label>
						</div>
						
						<div class="form-group-row row" >
							<div style="width: 100%">
								<table style="width: 100%">
									<tr>
										<td style="width: 14%; padding-right:5px;">
											<input name="programa" type="number" class="inputText" ng-model="componentec.componente.programa" ng-value="componentec.componente.programa" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;" />
							       			<label for="programa" class="floating-label">Programa</label>
										</td>
										<td style="width: 14%; padding-right:5px;">
											<input type="number" class="inputText" ng-model="componentec.componente.subprograma" ng-value="componentec.componente.subprograma" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;"/>
							  				<label for="isubprog" class="floating-label">Subprograma</label>
										</td>
										<td style="width: 14%; padding-right:5px;">
											<input type="number" class="inputText" ng-model="componentec.componente.proyecto_" ng-value="componentec.componente.proyecto" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;"/>
							  				<label for="iproy_" class="floating-label">Proyecto</label>
										</td>
										<td style="width: 14%; padding-right:5px;">
											<input type="number" class="inputText" ng-model="componentec.componente.actividad" ng-value="componentec.componente.actividad" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;"/>
								  			<label for="iobra" class="floating-label">Actividad</label>
										</td>
										<td style="width: 14%; padding-right:5px;">
											<input type="number" class="inputText" ng-model="componentec.componente.obra" ng-value="componentec.componente.obra" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;"/>
							 				<label for="iobra" class="floating-label">Obra</label>
										</td>
										<td style="width: 14%; padding-right:5px;">
											<input type="number" class="inputText" ng-model="componentec.componente.renglon" ng-value="componentec.componente.renglon" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;"/>
							  				<label for="fuente" class="floating-label">Renglon</label>
										</td>
										<td style="width: 14%; padding-right:5px;">
											<input type="number" class="inputText" ng-model="componentec.componente.ubicacionGeografica" ng-value="componentec.componente.ubicacionGeografica" onblur="this.setAttribute('value', this.value);" ng-maxlength="4" style="text-align: center;"/>
							  				<label for="fuente" class="floating-label">Ubicación Geográfica</label>
										</td>
									</tr>
								</table>
							</div>
						</div>
						
						<div class="form-group">
						   <input type="number" name="snip"  class="inputText" id="snip" 
						     ng-model="componentec.componente.snip" ng-value="componentec.componente.snip"   
						     onblur="this.setAttribute('value', this.value);" ng-required="false" >
						   <label class="floating-label">SNIP</label>
						</div>
							
						
						<div class="form-group">
				            <input type="text" class="inputText" id="iunie" name="iunie" ng-model="componentec.unidadejecutoranombre" ng-readonly="true" ng-required="true" 
				            	ng-click="componentec.buscarUnidadEjecutora()" ng-value="componentec.unidadejecutoranombre" onblur="this.setAttribute('value', this.value);"/>
				            <span class="label-icon" ng-click="componentec.buscarUnidadEjecutora()"><i class="glyphicon glyphicon-search"></i></span>
				          	<label for="campo3" class="floating-label">* Unidad Ejecutora</label>
						</div>
						<div class="form-group">
				            <input type="text" class="inputText" id="icomptipo" name="icomptipo" ng-model="componentec.componentetiponombre" ng-readonly="true" ng-required="true" 
				            	ng-click="componentec.buscarComponenteTipo()" ng-value="componentec.componentetiponombre" onblur="this.setAttribute('value', this.value);"/>
				            <span class="label-icon" ng-click="componentec.buscarComponenteTipo()"><i class="glyphicon glyphicon-search"></i></span>
				          	<label for="campo3" class="floating-label">* Tipo Componente</label>
						</div>
						<div ng-repeat="campo in componentec.camposdinamicos">
							<div ng-switch="campo.tipo">
								<div ng-switch-when="texto" class="form-group" >
									<input type="text" id="{{ 'campo_'+campo.id }}" ng-model="campo.valor" class="inputText" 
										ng-value="campo.valor" onblur="this.setAttribute('value', this.value);"/>	
									<label for="campo.id" class="floating-label">{{ campo.label }}</label>
								</div>
								<div ng-switch-when="entero" class="form-group" >
									<input type="number" id="{{ 'campo_'+campo.id }}" numbers-only ng-model="campo.valor" class="inputText"   
									ng-value="campo.valor" onblur="this.setAttribute('value', this.value);"/>
									<label for="campo.id" class="floating-label">{{ campo.label }}</label>
								</div>
								<div ng-switch-when="decimal" class="form-group" >
									<input type="number" id="{{ 'campo_'+campo.id }}" ng-model="campo.valor" class="inputText"  
									ng-value="campo.valor" onblur="this.setAttribute('value', this.value);"/>
									<label for="campo.id" class="floating-label">{{ campo.label }}</label>
								</div>
								<div ng-switch-when="booleano" class="form-group" >
									<input type="checkbox" id="{{ 'campo_'+campo.id }}" ng-model="campo.valor" />
									<label for="campo.id" class="floating-label">{{ campo.label }}</label>
								</div>
								<div ng-switch-when="fecha" class="form-group" >
									<input type="text" id="{{ 'campo_'+campo.id }}" class="inputText" uib-datepicker-popup="{{componentec.formatofecha}}" ng-model="campo.valor" is-open="campo.isOpen"
														datepicker-options="componentec.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-click="componentec.abrirPopupFecha($index)"
														ng-value="campo.valor" onblur="this.setAttribute('value', this.value);"/>
														<span class="label-icon" ng-click="componentec.abrirPopupFecha($index)">
															<i class="glyphicon glyphicon-calendar"></i>
														</span>
									<label for="campo.id" class="floating-label">{{ campo.label }}</label>
								</div>
								<div ng-switch-when="select" class="form-group" >
									<select id="{{ 'campo_'+campo.id }}" class="inputText" ng-model="campo.valor">
													<option value="">Seleccione una opción</option>
													<option ng-repeat="number in campo.opciones"
														ng-value="number.valor">{{number.label}}</option>
								</select>
									<label for="campo.id" class="floating-label">{{ campo.label }}</label>
								</div>
							</div>
						</div>
						
						
						<div class="form-group" >
						    <input type="text" class="inputText" id="iproyt" name="iproyt" ng-model="componentec.coordenadas" ng-value="componentec.coordenadas" 
								            		ng-click="componentec.open(componentec.componente.latitud, componentec.componente.longitud); " onblur="this.setAttribute('value', this.value);" ng-readonly="true" ng-required="false"/>
							<span class="label-icon" ng-click="componentec.open(componentec.componente.latitud, componentec.componente.longitud); "><i class="glyphicon glyphicon-map-marker"></i></span>
							<label for="campo3" class="floating-label">Coordenadas</label>
						</div>
						
						<div class="form-group">
						   <input type="text" name="idescrip"  class="inputText" id="idescrip" 
						     ng-model="componentec.componente.descripcion" ng-value="componentec.componente.descripcion"   
						     onblur="this.setAttribute('value', this.value);" ng-required="false" >
						   <label class="floating-label">Descripción</label>
						</div>
						
						<div class="form-group" >
					       <input type="number" class="inputText" ng-model="componentec.componente.costo" ng-value="componentec.componente.costo" onblur="this.setAttribute('value', this.value);" style="text-align: left" />
					       <label for="iprog" class="floating-label">Costo</label>
						</div>
						
						<div class="form-group" >
						    <input type="text" class="inputText" id="acumulacionCosto" name="acumulacionCosto" ng-model="componentec.componente.acumulacionCostoNombre" ng-value="componentec.componente.acumulacionCostoNombre" 
							ng-click="componentec.buscarAcumulacionCosto()" onblur="this.setAttribute('value', this.value);" ng-readonly="true" ng-required="componentec.componente.costo > 0"/>
							<span class="label-icon" ng-click="componentec.buscarAcumulacionCosto()"><i class="glyphicon glyphicon-search"></i></span>
							<label for="campo3" class="floating-label">Acumulación Costo</label>
						</div>
						
						<div class = "row">
							<div class="col-sm-6">
								<div class="form-group">
									<select class="inputText" ng-model="componentec.duracionDimension"
										ng-options="dim as dim.nombre for dim in componentec.dimensiones track by dim.value"
										 ng-required="true">
									</select>
									<label for="nombre" class="floating-label">* Dimension</label>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
								   <input class="inputText"  type="number"
								     ng-model="componentec.componente.duracion" ng-value="componentec.componente.duracion"   
								     onblur="this.setAttribute('value', this.value);"  min="1" max="100" ng-required="true" 
								     ng-readonly="componentec.duracionDimension.value != 0 ? false : true"
								     ng-change="componentec.componente.fechaInicio != null && componentec.duracionDimension.value != 0 ? componentec.cambioDuracion(componentec.duracionDimension) : ''">
								   <label class="floating-label">* Duración</label>
								</div>	
							</div>
							
							<div class="col-sm-6">
								<div class="form-group" >
								  <input type="text"  class="inputText" uib-datepicker-popup="{{componentec.formatofecha}}" ng-model="componentec.componente.fechaInicio" is-open="componentec.fi_abierto"
								            datepicker-options="componentec.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-change="componentec.cambioDuracion(componentec.duracionDimension);" ng-required="true"  
								            ng-click="componentec.abrirPopupFecha(1000)" ng-value="componentec.componente.fechaInicio" onblur="this.setAttribute('value', this.value);">
								            <span class="label-icon" ng-click="componentec.abrirPopupFecha(1000)">
								              <i class="glyphicon glyphicon-calendar"></i>
								            </span>
								  <label for="campo.id" class="floating-label">* Fecha de Inicio</label>
								</div>
							</div>
						
							<div class="col-sm-6">
								<div class="form-group" >
								  <input type="text"  class="inputText" uib-datepicker-popup="{{componentec.formatofecha}}" ng-model="componentec.componente.fechaFin" is-open="componentec.ff_abierto"
								            datepicker-options="componentec.ff_opciones" close-text="Cerrar" current-text="Hoy" clear-text="Borrar"  ng-required="true" ng-click=""
								            ng-value="componentec.componente.fechaFin" onblur="this.setAttribute('value', this.value);"
								            ng-readonly="true"/>
								            <span class="label-icon" ng-click="componentec.abrirPopupFecha(1001)">
								              <i class="glyphicon glyphicon-calendar"></i>
								            </span>
								  <label for="campo.id" class="floating-label">* Fecha de Fin</label>
								</div>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading label-form" style="text-align: center;">Datos de auditoría</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-sm-6" >
										<div class="form-group" style="text-align: right">
											<label  class="label-form" for="usuarioCreo">Usuario que creo</label>
				    						<p>{{ componentec.componente.usuarioCreo }}</p>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label class="label-form"  for="fechaCreacion">Fecha de creación</label>
				    						<p>{{ componentec.componente.fechaCreacion }}</p>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group" style="text-align: right">
											<label class="label-form"  for="usuarioActualizo">Usuario que actualizo</label>
				    						<p>{{ componentec.componente.usuarioActualizo }}</p>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label for="fechaActualizacion" class="label-form" >Fecha de actualizacion</label>
				    						<p>{{ componentec.componente.fechaActualizacion }}</p>
										</div>
									</div>
								</div>
							</div>
						</div>
				</form>
			</div>
			
			<div class="col-sm-12 operation_buttons" align="right">
				<div align="center" class="label-form">Los campos marcados con * son obligatorios</div>
				<div class="col-sm-12">
					<div class="btn-group">
						 <shiro:hasPermission name="5020">
						      <label class="btn btn-success" ng-click="form.$valid ? componentec.guardar() : ''" ng-disabled="!form.$valid" title="Guardar">
						      <span class="glyphicon glyphicon-floppy-saved"></span> Guardar</label>
						    </shiro:hasPermission>
						    <label class="btn btn-primary" ng-click="componentec.irATabla()" title="Ir a Tabla">
						    <span class="glyphicon glyphicon-list-alt"></span> Ir a Tabla</label>
	    			</div>
	    		</div>
    		</div>
		</div>
	</div>
