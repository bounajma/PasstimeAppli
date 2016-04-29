package com.passtime.passtimeappli.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the franchise_space database table.
 * 
 */
@Entity
@Table(name="franchise_space")
@NamedQuery(name="FranchiseSpace.findAll", query="SELECT f FROM FranchiseSpace f")
public class FranchiseSpace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="auto_validation")
	private byte autoValidation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_current_edition")
	private Date dateCurrentEdition;

	@Temporal(TemporalType.DATE)
	@Column(name="date_next_edition")
	private Date dateNextEdition;

	@Column(name="franchise_space_child")
	private int franchiseSpaceChild;

	@Column(name="guide_line_space")
	private float guideLineSpace;

	@Column(name="guide_lock")
	private byte guideLock;

	@Column(name="number_edition")
	private int numberEdition;

	@Column(name="paypal_address")
	private String paypalAddress;

	@Column(name="print_enable")
	private byte printEnable;

	@Column(name="stock_carte")
	private byte stockCarte;

	@Column(name="stock_guide")
	private byte stockGuide;

	@Column(name="tax_vat_registration")
	private String taxVatRegistration;

	//bi-directional many-to-one association to 
	@Transient
	@OneToMany(mappedBy="franchiseSpace")
	private List<Account> accounts;

	//bi-directional many-to-one association to GuidePagination
	@ManyToOne
	@JoinColumn(name="id_guide_pagination")
	private GuidePagination guidePagination;

	//bi-directional many-to-one association to Sector
	@ManyToOne
	@JoinColumn(name="id_sector")
	private Sector sector;

	//bi-directional many-to-one association to TaxVat
	@ManyToOne
	@JoinColumn(name="id_tax_vat")
	private TaxVat taxVat;

	//bi-directional many-to-one association to GroupCost
	@OneToMany(mappedBy="franchiseSpace")
	private List<GroupCost> groupCosts;

	//bi-directional many-to-one association to GuideAddPage
	@OneToMany(mappedBy="franchiseSpace")
	private List<GuideAddPage> guideAddPages;

	//bi-directional many-to-one association to IdeaWe
	@Transient
	@OneToMany(mappedBy="franchiseSpace")
	private List<IdeaWe> ideaWes;

	//bi-directional many-to-one association to IdeaWeProximity
	@OneToMany(mappedBy="franchiseSpace")
	private List<IdeaWeProximity> ideaWeProximities;

	//bi-directional many-to-one association to IdeaWeTestimonial
	@OneToMany(mappedBy="franchiseSpace")
	private List<IdeaWeTestimonial> ideaWeTestimonials;

	//bi-directional many-to-one association to InterviewAnswer
	@OneToMany(mappedBy="franchiseSpace")
	private List<InterviewAnswer> interviewAnswers;

	//bi-directional many-to-one association to MailPatronage
	@OneToMany(mappedBy="franchiseSpace")
	private List<MailPatronage> mailPatronages;

	//bi-directional many-to-one association to OrderForm
	@OneToMany(mappedBy="franchiseSpace")
	private List<OrderForm> orderForms;

	//bi-directional many-to-one association to PartnerOverall
	@Transient
	@OneToMany(mappedBy="franchiseSpace")
	private List<PartnerOverall> partnerOveralls;

	//bi-directional many-to-one association to PartnerSharing
	@OneToMany(mappedBy="franchiseSpace")
	private List<PartnerSharing> partnerSharings;

	//bi-directional many-to-one association to PrivilegeOffer
	@OneToMany(mappedBy="franchiseSpace")
	private List<PrivilegeOffer> privilegeOffers;

	//bi-directional many-to-one association to PromoCode
	@OneToMany(mappedBy="franchiseSpace")
	private List<PromoCode> promoCodes;

	//bi-directional many-to-one association to Testimony
	@OneToMany(mappedBy="franchiseSpace")
	private List<Testimony> testimonies;

	public FranchiseSpace() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAutoValidation() {
		return this.autoValidation;
	}

	public void setAutoValidation(byte autoValidation) {
		this.autoValidation = autoValidation;
	}

	public Date getDateCurrentEdition() {
		return this.dateCurrentEdition;
	}

	public void setDateCurrentEdition(Date dateCurrentEdition) {
		this.dateCurrentEdition = dateCurrentEdition;
	}

	public Date getDateNextEdition() {
		return this.dateNextEdition;
	}

	public void setDateNextEdition(Date dateNextEdition) {
		this.dateNextEdition = dateNextEdition;
	}

	public int getFranchiseSpaceChild() {
		return this.franchiseSpaceChild;
	}

	public void setFranchiseSpaceChild(int franchiseSpaceChild) {
		this.franchiseSpaceChild = franchiseSpaceChild;
	}

	public float getGuideLineSpace() {
		return this.guideLineSpace;
	}

	public void setGuideLineSpace(float guideLineSpace) {
		this.guideLineSpace = guideLineSpace;
	}

	public byte getGuideLock() {
		return this.guideLock;
	}

	public void setGuideLock(byte guideLock) {
		this.guideLock = guideLock;
	}

	public int getNumberEdition() {
		return this.numberEdition;
	}

	public void setNumberEdition(int numberEdition) {
		this.numberEdition = numberEdition;
	}

	public String getPaypalAddress() {
		return this.paypalAddress;
	}

	public void setPaypalAddress(String paypalAddress) {
		this.paypalAddress = paypalAddress;
	}

	public byte getPrintEnable() {
		return this.printEnable;
	}

	public void setPrintEnable(byte printEnable) {
		this.printEnable = printEnable;
	}

	public byte getStockCarte() {
		return this.stockCarte;
	}

	public void setStockCarte(byte stockCarte) {
		this.stockCarte = stockCarte;
	}

	public byte getStockGuide() {
		return this.stockGuide;
	}

	public void setStockGuide(byte stockGuide) {
		this.stockGuide = stockGuide;
	}

	public String getTaxVatRegistration() {
		return this.taxVatRegistration;
	}

	public void setTaxVatRegistration(String taxVatRegistration) {
		this.taxVatRegistration = taxVatRegistration;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setFranchiseSpace(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setFranchiseSpace(null);

		return account;
	}

	public GuidePagination getGuidePagination() {
		return this.guidePagination;
	}

	public void setGuidePagination(GuidePagination guidePagination) {
		this.guidePagination = guidePagination;
	}

	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public TaxVat getTaxVat() {
		return this.taxVat;
	}

	public void setTaxVat(TaxVat taxVat) {
		this.taxVat = taxVat;
	}

	public List<GroupCost> getGroupCosts() {
		return this.groupCosts;
	}

	public void setGroupCosts(List<GroupCost> groupCosts) {
		this.groupCosts = groupCosts;
	}

	public GroupCost addGroupCost(GroupCost groupCost) {
		getGroupCosts().add(groupCost);
		groupCost.setFranchiseSpace(this);

		return groupCost;
	}

	public GroupCost removeGroupCost(GroupCost groupCost) {
		getGroupCosts().remove(groupCost);
		groupCost.setFranchiseSpace(null);

		return groupCost;
	}

	public List<GuideAddPage> getGuideAddPages() {
		return this.guideAddPages;
	}

	public void setGuideAddPages(List<GuideAddPage> guideAddPages) {
		this.guideAddPages = guideAddPages;
	}

	public GuideAddPage addGuideAddPage(GuideAddPage guideAddPage) {
		getGuideAddPages().add(guideAddPage);
		guideAddPage.setFranchiseSpace(this);

		return guideAddPage;
	}

	public GuideAddPage removeGuideAddPage(GuideAddPage guideAddPage) {
		getGuideAddPages().remove(guideAddPage);
		guideAddPage.setFranchiseSpace(null);

		return guideAddPage;
	}

	public List<IdeaWe> getIdeaWes() {
		return this.ideaWes;
	}

	public void setIdeaWes(List<IdeaWe> ideaWes) {
		this.ideaWes = ideaWes;
	}

	public IdeaWe addIdeaWe(IdeaWe ideaWe) {
		getIdeaWes().add(ideaWe);
		ideaWe.setFranchiseSpace(this);

		return ideaWe;
	}

	public IdeaWe removeIdeaWe(IdeaWe ideaWe) {
		getIdeaWes().remove(ideaWe);
		ideaWe.setFranchiseSpace(null);

		return ideaWe;
	}

	public List<IdeaWeProximity> getIdeaWeProximities() {
		return this.ideaWeProximities;
	}

	public void setIdeaWeProximities(List<IdeaWeProximity> ideaWeProximities) {
		this.ideaWeProximities = ideaWeProximities;
	}

	public IdeaWeProximity addIdeaWeProximity(IdeaWeProximity ideaWeProximity) {
		getIdeaWeProximities().add(ideaWeProximity);
		ideaWeProximity.setFranchiseSpace(this);

		return ideaWeProximity;
	}

	public IdeaWeProximity removeIdeaWeProximity(IdeaWeProximity ideaWeProximity) {
		getIdeaWeProximities().remove(ideaWeProximity);
		ideaWeProximity.setFranchiseSpace(null);

		return ideaWeProximity;
	}

	public List<IdeaWeTestimonial> getIdeaWeTestimonials() {
		return this.ideaWeTestimonials;
	}

	public void setIdeaWeTestimonials(List<IdeaWeTestimonial> ideaWeTestimonials) {
		this.ideaWeTestimonials = ideaWeTestimonials;
	}

	public IdeaWeTestimonial addIdeaWeTestimonial(IdeaWeTestimonial ideaWeTestimonial) {
		getIdeaWeTestimonials().add(ideaWeTestimonial);
		ideaWeTestimonial.setFranchiseSpace(this);

		return ideaWeTestimonial;
	}

	public IdeaWeTestimonial removeIdeaWeTestimonial(IdeaWeTestimonial ideaWeTestimonial) {
		getIdeaWeTestimonials().remove(ideaWeTestimonial);
		ideaWeTestimonial.setFranchiseSpace(null);

		return ideaWeTestimonial;
	}

	public List<InterviewAnswer> getInterviewAnswers() {
		return this.interviewAnswers;
	}

	public void setInterviewAnswers(List<InterviewAnswer> interviewAnswers) {
		this.interviewAnswers = interviewAnswers;
	}

	public InterviewAnswer addInterviewAnswer(InterviewAnswer interviewAnswer) {
		getInterviewAnswers().add(interviewAnswer);
		interviewAnswer.setFranchiseSpace(this);

		return interviewAnswer;
	}

	public InterviewAnswer removeInterviewAnswer(InterviewAnswer interviewAnswer) {
		getInterviewAnswers().remove(interviewAnswer);
		interviewAnswer.setFranchiseSpace(null);

		return interviewAnswer;
	}

	public List<MailPatronage> getMailPatronages() {
		return this.mailPatronages;
	}

	public void setMailPatronages(List<MailPatronage> mailPatronages) {
		this.mailPatronages = mailPatronages;
	}

	public MailPatronage addMailPatronage(MailPatronage mailPatronage) {
		getMailPatronages().add(mailPatronage);
		mailPatronage.setFranchiseSpace(this);

		return mailPatronage;
	}

	public MailPatronage removeMailPatronage(MailPatronage mailPatronage) {
		getMailPatronages().remove(mailPatronage);
		mailPatronage.setFranchiseSpace(null);

		return mailPatronage;
	}

	public List<OrderForm> getOrderForms() {
		return this.orderForms;
	}

	public void setOrderForms(List<OrderForm> orderForms) {
		this.orderForms = orderForms;
	}

	public OrderForm addOrderForm(OrderForm orderForm) {
		getOrderForms().add(orderForm);
		orderForm.setFranchiseSpace(this);

		return orderForm;
	}

	public OrderForm removeOrderForm(OrderForm orderForm) {
		getOrderForms().remove(orderForm);
		orderForm.setFranchiseSpace(null);

		return orderForm;
	}

	public List<PartnerOverall> getPartnerOveralls() {
		return this.partnerOveralls;
	}

	public void setPartnerOveralls(List<PartnerOverall> partnerOveralls) {
		this.partnerOveralls = partnerOveralls;
	}

	public PartnerOverall addPartnerOverall(PartnerOverall partnerOverall) {
		getPartnerOveralls().add(partnerOverall);
		partnerOverall.setFranchiseSpace(this);

		return partnerOverall;
	}

	public PartnerOverall removePartnerOverall(PartnerOverall partnerOverall) {
		getPartnerOveralls().remove(partnerOverall);
		partnerOverall.setFranchiseSpace(null);

		return partnerOverall;
	}

	public List<PartnerSharing> getPartnerSharings() {
		return this.partnerSharings;
	}

	public void setPartnerSharings(List<PartnerSharing> partnerSharings) {
		this.partnerSharings = partnerSharings;
	}

	public PartnerSharing addPartnerSharing(PartnerSharing partnerSharing) {
		getPartnerSharings().add(partnerSharing);
		partnerSharing.setFranchiseSpace(this);

		return partnerSharing;
	}

	public PartnerSharing removePartnerSharing(PartnerSharing partnerSharing) {
		getPartnerSharings().remove(partnerSharing);
		partnerSharing.setFranchiseSpace(null);

		return partnerSharing;
	}

	public List<PrivilegeOffer> getPrivilegeOffers() {
		return this.privilegeOffers;
	}

	public void setPrivilegeOffers(List<PrivilegeOffer> privilegeOffers) {
		this.privilegeOffers = privilegeOffers;
	}

	public PrivilegeOffer addPrivilegeOffer(PrivilegeOffer privilegeOffer) {
		getPrivilegeOffers().add(privilegeOffer);
		privilegeOffer.setFranchiseSpace(this);

		return privilegeOffer;
	}

	public PrivilegeOffer removePrivilegeOffer(PrivilegeOffer privilegeOffer) {
		getPrivilegeOffers().remove(privilegeOffer);
		privilegeOffer.setFranchiseSpace(null);

		return privilegeOffer;
	}

	public List<PromoCode> getPromoCodes() {
		return this.promoCodes;
	}

	public void setPromoCodes(List<PromoCode> promoCodes) {
		this.promoCodes = promoCodes;
	}

	public PromoCode addPromoCode(PromoCode promoCode) {
		getPromoCodes().add(promoCode);
		promoCode.setFranchiseSpace(this);

		return promoCode;
	}

	public PromoCode removePromoCode(PromoCode promoCode) {
		getPromoCodes().remove(promoCode);
		promoCode.setFranchiseSpace(null);

		return promoCode;
	}

	public List<Testimony> getTestimonies() {
		return this.testimonies;
	}

	public void setTestimonies(List<Testimony> testimonies) {
		this.testimonies = testimonies;
	}

	public Testimony addTestimony(Testimony testimony) {
		getTestimonies().add(testimony);
		testimony.setFranchiseSpace(this);

		return testimony;
	}

	public Testimony removeTestimony(Testimony testimony) {
		getTestimonies().remove(testimony);
		testimony.setFranchiseSpace(null);

		return testimony;
	}

}