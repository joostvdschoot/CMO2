// Import Libraries
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
// Import Services
import { CountryService } from '../../services/country.service';
import { AccountService } from '../../services/account.service';
import { OrganizationService } from '../../services/organization.service';
// Import Models
import { Lessor } from '../../domain/cmo_db/lessor';
import { Country } from '../../domain/cmo_db/country';
import { Account } from '../../domain/cmo_db/account';
import { Organization } from '../../domain/cmo_db/organization';

// START - USED SERVICES
/**
* CountryService.list
*	@description CRUD ACTION list
*
* AccountService.findByLessor
*	@description CRUD ACTION findByLessor
*	@param Objectid key Id of model to search for
*
* OrganizationService.findByLessor
*	@description CRUD ACTION findByLessor
*	@param Objectid key Id of model to search for
*
*/
// END - USED SERVICES

/**
 * This component allows to edit a Lessor
 */
@Component({
    selector: 'app-lessor-edit',
    templateUrl: 'lessor-edit.component.html',
    styleUrls: ['lessor-edit.component.css']
})
export class LessorEditComponent implements OnInit {
    item: Lessor;
    listCountry: Country[];
    listOperatingEntity: Lessor[];
    externalAccount_Lessor: Account[];
    externalOrganization_Lessor: Organization[];
    model: Lessor;
    formValid: Boolean;

    constructor(
    private countryService: CountryService,
    private accountService: AccountService,
    private organizationService: OrganizationService,
    private route: ActivatedRoute,
    private location: Location) {
        // Init item
        this.item = new Lessor();
        this.externalAccount_Lessor = [];
        this.externalOrganization_Lessor = [];
    }

    /**
     * Init
     */
    ngOnInit() {
        this.route.params.subscribe(param => {
            const id: string = param['id'];
            if (id !== 'new') {
                this.lessorService.get(id).subscribe(item => this.item = item);
                this.accountService.findByLessor(id).subscribe(list => this.externalAccount_Lessor = list);
                this.organizationService.findByLessor(id).subscribe(list => this.externalOrganization_Lessor = list);
            }
            // Get relations
            this.countryService.list().subscribe(list => this.listCountry = list);
            this.lessorService.list().subscribe(list => this.listOperatingEntity = list);
        });
    }


    /**
     * Save Lessor
     *
     * @param {boolean} formValid Form validity check
     * @param Lessor item Lessor to save
     */
    save(formValid: boolean, item: Lessor): void {
        this.formValid = formValid;
        if (formValid) {
            if (item._id) {
                this.lessorService.update(item).subscribe(data => this.goBack());
            } else {
                this.lessorService.create(item).subscribe(data => this.goBack());
            } 
        }
    }

    /**
     * Go Back
     */
    goBack(): void {
        this.location.back();
    }


}



