package com.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "retur_pembelian")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class ReturPembelian {
	@Id
    @Column(name="nota_beli", length=10)
    private String notaBeli;
    
    @Column(name="tgl_retur")
    private Date tglRetur;
    
    @Column(name="nama_barang", length=15)
    private String namaBarang;
    
    @JoinColumn(name = "kd_supplier",referencedColumnName = "kd_supplier")
    @ManyToOne
    private MstSupplier kodeSupplier;
    
    @Column(name="nama_supplier", length=15)
    private String namaSupplier;
    
    @Column(name="jumlah_barang", length=15)
    private Integer jumlahBarang;
    
    @Column(name="keterangan", length=15)
    private String keterangan;
    
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
}
