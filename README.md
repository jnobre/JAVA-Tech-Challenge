BlipTest Java
================================

Implementação um microservice com 3 operações possiveis, a primeira obtem todas as aquisições válidas, a segunda actualiza a quantidade de produtos de uma aquisção e por último o armazenamento de uma nova aquisição.  <br /><br />

Run:<br />
	1. Classe main está localizada no package main.WebServer <br />
	2. WebServer esta escuta no URL: http://localhost:8000/blipTest <br />
    3. Parametros na chamado do serviço: <br />
    	3.1. operation=1 : fectch valid purchase <br />
    	3.2. operation=2 : actualizar a quantidade de produtos vendidos numa aquisição <br />
    		3.2.1. idPurchase=134 : actualizar aquisição com o  id = 134 <br />
    		3.2.2. quantity=2: actualiar a qunatidade para 2 produtos <br />
    	3.3.  operation=3 : stored new purchase with respect atributes <br />
    		3.3.1. idPurchase  <br />
    		3.3.2. idPurchaseDetail <br />
    		3.3.3. quantity <br />
    		3.3.4. productType <br />
    		3.3.5. description <br />
    		3.3.6. expire <br />
    		3.3.7. value <br />
    4. Exemplos:  <br /> 
    	4.1. http://localhost:8000/blipTest?operation=1 : obtem todos as aquisições válidas. <br />
    	4.2. http://localhost:8000/blipTest?operation=2&idPurchase=122&quantity=2 : actualiza aquisição nº122 para a quantidade  <br />
    	4.3. http://localhost:8000/blipTest?operation=3&idPurchase=123&idPurchaseDetail=456&quantity=12&productType=tipo&description=descricao& <br />expire=20150203&value=45015 <br />

    


