// Import Libraries
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
// Import Services
import { CreditLineService } from '../../services/credit-line.service';
import { OrganizationService } from '../../services/organization.service';
// Import Models
import { CreditLine } from '../../domain/cmo_db/credit-line';
import { Organization } from '../../domain/cmo_db/organization';

// START - USED SERVICES
/**
* CreditLineService.create
*	@description CRUD ACTION create
*
* CreditLineService.update
*	@description CRUD ACTION update
*	@param ObjectId id Id
*
* CreditLineService.get
*	@description CRUD ACTION get
*	@param ObjectId id Id resource
*
* OrganizationService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component allows to edit a CreditLine
 */
@Component({
    selector: 'app-credit-line-edit',
    templateUrl: 'credit-line-edit.component.html',
    styleUrls: ['credit-line-edit.component.css']
})
export class CreditLineEditComponent implements OnInit {
    item: CreditLine;
    listOrganization: Organization[];
    model: CreditLine;
    formValid: Boolean;

    constructor(
    private creditlineService: CreditLineService,
    private organizationService: OrganizationService,
    private route: ActivatedRoute,
    private location: Location) {
        // Init item
        this.item = new CreditLine();
    }

    /**
     * Init
     */
    ngOnInit() {
        this.route.params.subscribe(param => {
            const id: string = param['id'];
            if (id !== 'new') {
                this.creditlineService.get(id).subscribe(item => this.item = item);
            }
            // Get relations
            this.organizationService.list().subscribe(list => this.listOrganization = list);
        });
    }


    /**
     * Save CreditLine
     *
     * @param {boolean} formValid Form validity check
     * @param CreditLine item CreditLine to save
     */
    save(formValid: boolean, item: CreditLine): void {
        this.formValid = formValid;
        if (formValid) {
            if (item._id) {
                this.creditlineService.update(item).subscribe(data => this.goBack());
            } else {
                this.creditlineService.create(item).subscribe(data => this.goBack());
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



