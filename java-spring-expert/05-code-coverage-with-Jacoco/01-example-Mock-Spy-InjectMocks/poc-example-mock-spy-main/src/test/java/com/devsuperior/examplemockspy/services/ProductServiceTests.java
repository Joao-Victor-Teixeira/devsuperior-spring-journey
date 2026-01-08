package com.devsuperior.examplemockspy.services;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsuperior.examplemockspy.dto.ProductDTO;
import com.devsuperior.examplemockspy.entities.Product;
import com.devsuperior.examplemockspy.repositories.ProductRepository;
import com.devsuperior.examplemockspy.services.exceptions.InvalidDataException;
import com.devsuperior.examplemockspy.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    @Spy
    private ProductService serviceSpy;

    @Mock
    private ProductRepository repository;

    private long existingProductId, nonExistingProductId;
    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() throws Exception{
        existingProductId = 1L;
        nonExistingProductId = 2L;

        product = new Product(1L, "Playstation", 10.0);
        productDTO = new ProductDTO(product);

        Mockito.when(repository.save(any())).thenReturn(product);

        Mockito.when(repository.getReferenceById(existingProductId)).thenReturn(product);
        Mockito.when(repository.getReferenceById(nonExistingProductId)).thenThrow(EntityNotFoundException.class);
    }

    @Test
    public void insertShouldReturnProductDTOWhenValidData(){

        Mockito.doNothing().when(serviceSpy).validateData(productDTO);

        ProductDTO result = serviceSpy.insert(productDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getName(), "Playstation");
    }

   	@Test
	public void insertShouldReturnInvalidDataExceptionWhenProductNameIsBlank() {
		
		productDTO.setName("");
		
		Mockito.doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);
		
		Assertions.assertThrows(InvalidDataException.class, () -> {
	    	
	    	@SuppressWarnings("unused")
            ProductDTO result = serviceSpy.insert(productDTO);
		});
	}

    @Test
    public void insertShouldReturnInvalidDataExceptionWhenProductPriceIsNegative(){

        productDTO.setPrice(-5.0);

        Mockito.doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () ->{

            @SuppressWarnings("unused")
            ProductDTO result = serviceSpy.insert(productDTO);
        });
    }

    @Test
    public void updateShouldReturnProductDTOWhenIdExistsAndValidData(){

        Mockito.doNothing().when(serviceSpy).validateData(productDTO);

        ProductDTO result = serviceSpy.update(existingProductId,productDTO);

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getName());
        Assertions.assertEquals(result.getName(), "Playstation");
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(result.getId(), 1L);
    }

    @Test
    public void updateShouldReturnInvalidDataExceptionWhenIdExistsAndProductNameIsBlank(){

        productDTO.setName("");
		
		Mockito.doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);
		
		Assertions.assertThrows(InvalidDataException.class, () -> {
	    	
	    	@SuppressWarnings("unused")
            ProductDTO result = serviceSpy.update(existingProductId,productDTO);
		});
    }

    @Test
    public void updateShouldReturnInvalidDataExceptionWhenIdExistsAndPriceIsNegative(){

        productDTO.setPrice(-5.0);

        Mockito.doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () ->{

            @SuppressWarnings("unused")
            ProductDTO result = serviceSpy.update(existingProductId,productDTO);
        });

    }

    @Test
    public void updateShouldReturnResourceNotFoundExceptionWhenIdDoesNotExistAndValidData(){
		
		Mockito.doThrow(ResourceNotFoundException.class).when(serviceSpy).validateData(productDTO);
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
	    	
	    	@SuppressWarnings("unused")
            ProductDTO result = serviceSpy.update(nonExistingProductId,productDTO);
		});
    }

    @Test
    public void updateShouldReturnInvalidDataExceptionWhenIdDoesNotExistAndNameIsBlank() {
        productDTO.setName("");

        Mockito.doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);
		
		Assertions.assertThrows(InvalidDataException.class, () -> {
	    	
	    	@SuppressWarnings("unused")
            ProductDTO result = serviceSpy.update(nonExistingProductId,productDTO);
		});
    }

    @Test
    public void updateShouldReturnInvalidDataExceptionWhenIdDoesNotExistAndPriceIsNegative(){

        productDTO.setPrice(-5.0);

        Mockito.doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);
		
		Assertions.assertThrows(InvalidDataException.class, () -> {
	    	
	    	@SuppressWarnings("unused")
            ProductDTO result = serviceSpy.update(nonExistingProductId,productDTO);
		});
    }
}
